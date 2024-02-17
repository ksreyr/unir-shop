package com.unir.webdev.books.infrastructure.searchfilter.mappers;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Author;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Available;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.BookName;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Image;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Isbn;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Language;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Rate;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.ReleaseYear;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BookMapper {
    @Contract ("_ -> new")
    public static @NotNull Book fromElaToDomain(@NotNull BookEntity bookEntity) {
        return new Book(bookEntity.bookId(),
                        new com.unir.webdev.books.domain.valueObjects.BookName(bookEntity.bookName()
                                                                                         .bookName()),
                        new com.unir.webdev.books.domain.valueObjects.Isbn(bookEntity.isbn()
                                                                                     .isbn()),
                        new com.unir.webdev.books.domain.valueObjects.Image(bookEntity.image()
                                                                                      .url()),
                        new com.unir.webdev.books.domain.valueObjects.Author(bookEntity.author()
                                                                                       .author()),
                        new com.unir.webdev.books.domain.valueObjects.ReleaseYear(bookEntity.releaseYear()
                                                                                            .releaseYear()),
                        new com.unir.webdev.books.domain.valueObjects.Rate(bookEntity.rate()
                                                                                     .rate()),
                        new com.unir.webdev.books.domain.valueObjects.Language(bookEntity.language()
                                                                                         .language()),
                        new com.unir.webdev.books.domain.valueObjects.Available(bookEntity.available()
                                                                                          .available()));
    }



    @Contract ("_ -> new")
    public static @NotNull BookEntity fromDomainToEla(@NotNull Book book) {
        return new BookEntity(book.bookId(),
                              new BookName(book.bookName()
                                               .bookName()),
                              new Isbn(book.isbn()
                                           .isbn()),
                              new Image(book.image()
                                            .url()),
                              new Author(book.author()
                                             .author()),
                              new ReleaseYear(book.releaseYear()
                                                  .releaseYear()),
                              new Rate(book.rate()
                                           .rate()),
                              new Language(book.language()
                                               .language()),
                              new Available(book.available()
                                                .available()));
    }
}
