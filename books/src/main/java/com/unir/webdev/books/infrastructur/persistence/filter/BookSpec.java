package com.unir.webdev.books.infrastructur.persistence.filter;

import com.unir.webdev.books.infrastructur.persistence.entity.BookEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class BookSpec {
    public  Specification<BookEntity> filterColumns(String name,
                                                    String author) {
        return (root, query, criteriaBuilder) -> {
            var predicateNameStream = Stream.of(criteriaBuilder.like(root.get(
                    "bookName").get("bookName"), "%" + name + "%"));
            var predicateCategoryStream = Stream.of(criteriaBuilder.like(root.get(
                    "author").get("author"), "%" + author + "%"));
            return criteriaBuilder.and(Stream.concat(predicateCategoryStream,
                                                     predicateNameStream).toArray(Predicate[] :: new));
        };
    }

}
