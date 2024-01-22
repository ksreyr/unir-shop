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
                                .map(BookMapper :: fromDbToDomain)
                                .toList();
    }

    @Override
    public Boolean areValidBooks(List<UUID> booksID) {
        return booksID.stream()
                      .allMatch(bookRepositoryJPA :: existsById);
    }

    @Override
    public void changeUnavailabilityOf(List<UUID> books) {
        books.stream()
             .map(bookRepositoryJPA :: findById)
             .map(bookEntity -> bookEntity.get()
                                          .makeUnavailable())
             .forEach(bookRepositoryJPA :: save);
    }

    @Override
    public void changeAvailabilityOf(List<UUID> books) {
        books.stream()
             .map(bookRepositoryJPA :: findById)
             .map(bookEntity -> bookEntity.get()
                                          .makeAvailable())
             .forEach(bookRepositoryJPA :: save);
    }


    @Override
    public boolean areAvailable(List<UUID> booksIDs) {
        return booksIDs.stream()
                       .map(bookRepositoryJPA :: findById)
                       .allMatch(bookEntity -> bookEntity.get()
                                                         .available()
                                                         .available());

    }
}
