package com.unir.webdev.books.infrastructure.repositories;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.BookRepository;
import com.unir.webdev.books.infrastructure.persistence.BookRepositoryJPA;
import com.unir.webdev.books.infrastructure.persistence.entity.BookEntity;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Available;
import com.unir.webdev.books.infrastructure.persistence.filter.BookSpec;
import com.unir.webdev.books.infrastructure.persistence.mappers.BookMapperPersistence;
import com.unir.webdev.books.infrastructure.searchfilter.inerface.ElasticInterface;
import com.unir.webdev.books.infrastructure.searchfilter.mappers.BookMapper;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@FieldDefaults (makeFinal = true, level = AccessLevel.PRIVATE)
@Qualifier ("JPAImp")
public class BookRepositoryJPAImp implements BookRepository {
    BookRepositoryJPA bookRepositoryJPA;
    ElasticInterface bookRepositoryElaImp;
    BookSpec bookSpec;

    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryJPA.findAll()
                                .stream()
                                .map(BookMapperPersistence :: fromDbToDomain)
                                .toList();
    }

    @Override
    public List<Book> getBooksBy(String name, String author) {
        return bookRepositoryJPA.findAll(bookSpec.filterColumns(name, author))
                                .stream()
                                .map(BookMapperPersistence :: fromDbToDomain)
                                .toList();
    }

    @Override
    public Boolean isValidBook(UUID bookID) {
        return bookRepositoryJPA.existsById(bookID);
    }

    @Override
    public Either<String, UUID> changeToUnavailability(UUID book) {
        bookRepositoryElaImp.findById(book)
                            .map(com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity :: makeUnavailable)
                            .map(bookRepositoryElaImp :: save);
        return Try.of(() -> Option.of(book)
                                  .map(bookRepositoryJPA :: findById)
                                  .flatMap(Option::ofOptional)
                                  .map(BookEntity :: makeUnavailable)
                                  .map(bookRepositoryJPA :: save)
                                  .map(BookEntity :: bookId)
                                  .get())
                  .toEither("Not changed Availability at DB");
    }

    @Override
    public UUID changeAvailabilityOf(UUID book) {
        bookRepositoryElaImp.findById(book)
                            .map(com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity :: makeAvailable)
                            .map(bookRepositoryElaImp :: save);
        return Optional.of(book)
                       .flatMap(bookRepositoryJPA :: findById)
                       .map(BookEntity :: makeAvailable)
                       .map(bookRepositoryJPA :: save)
                       .map(BookEntity :: bookId)
                       .orElseThrow(IllegalStateException :: new);
    }

    @Override
    public Either<String, Book> updateBook(Book book) {
        return Try.of(() -> bookRepositoryJPA.findById(book.bookId())
                                             .get())
                  .map(bookEntity -> bookEntity.updateEntity(BookMapperPersistence.fromDomainToDb(book)))
                  .map(bookRepositoryJPA :: save)
                  .map(BookMapperPersistence :: fromDbToDomain)
                  .toEither("Not update possible at DB");
    }

    @Override
    public Either<String, Book> createBook(Book book) {
        bookRepositoryElaImp.save(BookMapper.fromDomainToEla(book));
        return Try.of(() -> bookRepositoryJPA.save(BookMapperPersistence.fromDomainToDb(book)))
                  .map(BookMapperPersistence :: fromDbToDomain)
                  .toEither("Error to save at DB");
    }

    @Override
    public void deleteBook(UUID book) {
        bookRepositoryElaImp.findById(book)
                            .ifPresent(bookRepositoryElaImp :: delete);
        bookRepositoryJPA.deleteById(book);
    }


    @Override
    public boolean areAvailable(UUID bookID) {

        return Optional.ofNullable(bookID)
                       .map(bookRepositoryJPA :: findById)
                       .flatMap(bookEntity -> bookEntity.map(BookEntity :: available))
                       .map(Available :: available)
                       .orElse(false);

    }
}
