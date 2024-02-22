package com.unir.webdev.books.infrastructure.repositories;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.SearchInterface;
import com.unir.webdev.books.infrastructure.repositories.DTO.AggretorDetails;
import com.unir.webdev.books.infrastructure.repositories.DTO.BooksResponse;
import com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity;
import com.unir.webdev.books.infrastructure.searchfilter.inerface.ElasticInterface;
import com.unir.webdev.books.infrastructure.searchfilter.mappers.BookMapper;
import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchAggregation;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
@Qualifier ("ElaImp")
public class BookRepositoryElaImp implements SearchInterface {
    private final String[] searchSearchFields = {
            "bookName.bookName", "bookName" + ".bookName" + "._2gram",
            "bookName.bookName._3gram", "author.author", "author.author._2gram",
            "author.author._3gram", "Sinopsis", "ISBN"};
    private final String[] searchSearchFieldsYear = {
            "releaseYear.releaseYear", "releaseYear.releaseYear._2gram",
            "releaseYear.releaseYear._3gram"};
    ElasticsearchOperations elasticsearchOperations;
    ElasticInterface elasticInterface;

    @Override
    public BooksResponse buildResponse(String search,
                                       String releaseYear,
                                       Boolean aggregate
                                      )
    {


        HitsData hitsData = new HitsData(search, releaseYear, aggregate);
        SearchHits<BookEntity> searchHits = getSearchHits(hitsData);
        List<Book> collect = getBooks(searchHits);
        var aggregates = getAggregates(hitsData).stream()
                          .map(stringTermsBucket -> new AggretorDetails(
                                  stringTermsBucket.key()
                                                   .stringValue(),
                                  stringTermsBucket.docCount()))
                          .collect(Collectors.toList());
        return new BooksResponse(
                collect,
                aggregates);
    }

    @Override
    public List<Book> getBookBy(String search,
                                String anoPublicacion,
                                Boolean aggregate
                               )
    {
        HitsData data = new HitsData(search,
                anoPublicacion,
                aggregate);
        SearchHits<BookEntity> searchHits = getSearchHits(data);
        List<Book> collect = getBooks(searchHits);
        return collect;
    }

    private List<co.elastic.clients.elasticsearch._types.aggregations.StringTermsBucket> getAggregates(HitsData hitsData)
    {
        SearchHits<BookEntity> searchHits = getSearchHits(hitsData);
        if (searchHits.hasAggregations() && hitsData.aggregate)
        {
            var aggregations = (ArrayList<ElasticsearchAggregation>) searchHits.getAggregations().aggregations();
            return aggregations.get(0)
                               .aggregation()
                               .getAggregate()
                               .sterms()
                               .buckets()
                               .array();
        }
        return List.of();
    }

    @NotNull
    private static List<Book> getBooks(SearchHits<BookEntity> searchHits)
    {
        List<Book> collect = searchHits.getSearchHits()
                                       .stream()
                                       .map(hit -> BookMapper.fromElaToDomain(hit.getContent()))
                                       .collect(Collectors.toList());
        return collect;
    }


    public record HitsData(String search,
                    String anoPublicacion,
                    Boolean aggregate){}

    @NotNull
    private SearchHits<BookEntity> getSearchHits( HitsData data)
    {
        // Construyo Request
        NativeQueryBuilder nativeQueryBuilder = NativeQuery.builder();
        if (data.search != null || data.anoPublicacion != null)
        {
            var multiMatchQuery = MultiMatchQuery.of(m -> {
                if (data.anoPublicacion != null && ! data.anoPublicacion.isBlank())
                {
                    m.fields(
                             data.anoPublicacion,
                             searchSearchFieldsYear)
                     .type(TextQueryType.BoolPrefix)
                     .query(data.anoPublicacion);
                }
                if (data.search != null && ! data.search.isBlank())
                {
                    m.fields(
                             data.search,
                             searchSearchFields)
                     .type(TextQueryType.BoolPrefix)
                     .query(data.search);
                }
                return m;
            });
            var query =
                    Query.of(q -> q.bool(b -> b.must(builder -> builder.multiMatch(multiMatchQuery))));
            nativeQueryBuilder = nativeQueryBuilder.withQuery(query);
        }
        //////////// Agregates
        if (Boolean.TRUE.equals(data.aggregate))
        {
            Aggregation termsAggregation =
                    Aggregation.of(subBuilder -> subBuilder.terms(termsBuilder -> termsBuilder.field("language.language.keyword")
                                                                                              .size(10000)));
            nativeQueryBuilder.withAggregation(
                    "idioma_aggregation",
                    termsAggregation);
        }
        //Make Resuqet
        SearchHits<BookEntity> searchHits = elasticsearchOperations.search(
                nativeQueryBuilder.build(),
                BookEntity.class);
        return searchHits;
    }

    @Override
    public List<Book> getBookBy(String name,
                                String author
                               )
    {
        Query query =
                QueryBuilders.bool(b -> b.must(m -> m.match(mt -> mt.field("author" +
                                                                           ".author")
                                                                    .query(author))));

        NativeQuery nativeQuery = NativeQuery.builder()
                                             .withQuery(query)
                                             .build();

        SearchHits<BookEntity> searchHits = elasticsearchOperations.search(
                nativeQuery,
                BookEntity.class);

        return searchHits.getSearchHits()
                         .stream()
                         .map(hit -> BookMapper.fromElaToDomain(hit.getContent()))
                         .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks()
    {
        Iterable<BookEntity> all = elasticInterface.findAll();
        List<BookEntity> books = new ArrayList<>();
        for (BookEntity book : all)
        {
            books.add(book);
        }
        return books.stream()
                    .map(BookMapper :: fromElaToDomain)
                    .toList();
    }

    @Override
    public Either<String, Book> updateBook(Book book)
    {
        return null;
    }
}
