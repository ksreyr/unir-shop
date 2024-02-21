package com.unir.webdev.books.infrastructure.repositories;

import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.SearchInterface;
import com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity;
import com.unir.webdev.books.infrastructure.searchfilter.inerface.ElasticInterface;
import com.unir.webdev.books.infrastructure.searchfilter.mappers.BookMapper;
import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
@Qualifier ("ElaImp")
public class BookRepositoryElaImp implements SearchInterface {
    private final String[] searchSearchFields = {"bookName.bookName", "bookName" +
                                                                      ".bookName" +
                                                                      "._2gram",
            "bookName.bookName._3gram", "author.author", "author.author._2gram",
            "author.author._3gram", "Sinopsis", "ISBN"};
    ElasticsearchOperations elasticsearchOperations;
    ElasticInterface elasticInterface;

    @Override
    public List<Book> getBooksBy(String search,
                                 String anoPublicacion,
                                 String idioma,
                                 Boolean aggregate
                                ) {

        var builder = NativeQuery.builder();
        List<Query> multiMatchQueries = Stream.of(search, anoPublicacion, idioma)
                                              .map(s -> MultiMatchQuery.of(m -> m
                                                      .fields(s, searchSearchFields)
                                                      .type(TextQueryType.PhrasePrefix)
                                                      .query(s)))
                                              .map(mmq -> Query.of(q -> q.bool(b -> b.must(must -> must.multiMatch(mmq)))))
                                              .toList();

        Query combinedQuery = Query.of(q -> q.bool(b -> b.must(new ArrayList<>(multiMatchQueries))));

        var nativeQuery = builder.withQuery(combinedQuery)
                                 .withPageable(PageRequest.of(
                                         0,
                                         10))
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
    public List<Book> getBooksBy(String name,
                                 String author
                                ) {
        Query query = QueryBuilders.bool(b -> b.must(m -> m.match(mt -> mt.field(
                "author.author")
                                                                          .query(author))));

        NativeQuery nativeQuery = NativeQuery.builder()
                                             .withQuery(query)
                                             .withPageable(PageRequest.of(
                                                     0,
                                                     10))
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
    public List<Book> getAllBooks() {
        Iterable<BookEntity> all = elasticInterface.findAll();
        List<BookEntity> books = new ArrayList<>();
        for (BookEntity book : all) {
            books.add(book);
        }
        return books.stream()
                    .map(BookMapper :: fromElaToDomain)
                    .toList();
    }

    @Override
    public Either<String, Book> updateBook(Book book) {
        return null;
    }
}
