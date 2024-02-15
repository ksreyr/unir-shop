package com.unir.webdev.books.infrastructure.searchfilter.entity;

import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Isbn;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.BookName;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Author;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Image;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.ReleaseYear;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Rate;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Language;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Available;
import lombok.Builder;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@AllArgsConstructor
@Document (indexName = "books")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Accessors(fluent = true)
@Builder
public class BookEntity {
    @Id UUID bookId;

    BookName bookName;

    Isbn isbn;

    Image image;

    Author author;

    ReleaseYear releaseYear;

    Rate rate;

    Language language;

    Available available;

    public BookEntity makeUnavailable() {
        this.available = new Available(false);
        return this;
    }

    public BookEntity makeAvailable() {
        this.available = new Available(true);
        return this;
    }

    public BookEntity updateEntity(BookEntity book) {
        this.bookName = new BookName(book.bookName.bookName());
        this.isbn = new Isbn(book.isbn.isbn());
        this.image = new Image(book.image.url());
        this.author = new Author(book.author.author());
        this.releaseYear = new ReleaseYear(book.releaseYear.releaseYear());
        this.rate = new Rate(book.rate.rate());
        this.language = new Language(book.language.language());
        this.available = new Available(book.available.available());
        return this;
    }
}
