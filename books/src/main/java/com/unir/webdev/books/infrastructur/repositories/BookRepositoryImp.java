package com.unir.webdev.books.infrastructur.repositories;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.BookRepository;
import com.unir.webdev.books.infrastructur.persistence.BookRepositoryJPA;
import com.unir.webdev.books.infrastructur.persistence.filter.BookSpec;
import com.unir.webdev.books.infrastructur.persistence.mappers.BookMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@FieldDefaults (makeFinal = true, level = AccessLevel.PRIVATE)
public class BookRepositoryImp implements BookRepository {
    BookRepositoryJPA bookRepositoryJPA;
    BookSpec bookSpec;

    @Override
    public List<Book> getAllProducts() {
        return bookRepositoryJPA.findAll()
                                .stream()
                                .map(BookMapper :: fromDbToDomain)
                                .toList();
    }

    @Override
    public List<Book> getAllProductsBy(String name, String author) {
        return bookRepositoryJPA.findAll(bookSpec.filterColumns(name, author))
                                .stream()
                                .map(BookMapper ::fromDbToDomain)
                                .toList();
    }

    @Override
    public Boolean areValidateIDs(List<UUID> booksID) {
        return booksID.stream().anyMatch(bookRepositoryJPA :: existsById);
    }
}
