package com.unir.webdev.books.infrastructur.persistence.entity;

import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.Author;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.Available;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.BookName;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.Image;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.Isbn;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.Language;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.Rate;
import com.unir.webdev.books.infrastructur.persistence.entity.valueObjects.ReleaseYear;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID bookId;

    @Embedded
    BookName bookName;

    @Embedded
    Isbn isbn;

    @Embedded
    Image image;

    @Embedded
    Author author;

    @Embedded
    ReleaseYear releaseYear;

    @Embedded
    Rate rate;

    @Embedded
    Language language;
    @Embedded
    Available available;

    public BookEntity makeUnavailable() {
        this.available = new Available(false);
        return this;
    }
    public BookEntity makeAvailable() {
        this.available = new Available(true);
        return this;
    }
}
