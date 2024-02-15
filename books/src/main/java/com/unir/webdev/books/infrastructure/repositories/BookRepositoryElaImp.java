package com.unir.webdev.books.infrastructure.repositories;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity;
import com.unir.webdev.books.infrastructure.searchfilter.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;

@Repository
@RequiredArgsConstructor
public class BookRepositoryElaImp {

    private final ElasticsearchOperations elasticsearchOperations;

    public List<Book> findBooks(String name, String author) {
        Query query = QueryBuilders.bool(b -> b
                .must(m -> m.match(mt -> mt
                        .field("bookName.bookName")
                        .query(name)))
                .must(m -> m.match(mt -> mt
                        .field("author.author")
                        .query(author))));

        NativeQuery nativeQuery = NativeQuery.builder()
                                             .withQuery(query)
                                             .withPageable(PageRequest.of(0, 10))
                                             .build();

        SearchHits<BookEntity> searchHits = elasticsearchOperations.search(nativeQuery, BookEntity.class);

        return searchHits.getSearchHits().stream()
                         .map(hit -> BookMapper.fromElaToDomain(hit.getContent()))
                         .collect(Collectors.toList());
    }
}
