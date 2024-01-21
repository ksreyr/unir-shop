package com.unir.webdev.books.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unir.webdev.books.domain.valueObjects.Author;
import com.unir.webdev.books.domain.valueObjects.BookName;
import com.unir.webdev.books.domain.valueObjects.Image;
import com.unir.webdev.books.domain.valueObjects.Isbn;
import com.unir.webdev.books.domain.valueObjects.Language;
import com.unir.webdev.books.domain.valueObjects.Rate;
import com.unir.webdev.books.domain.valueObjects.ReleaseYear;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @JsonProperty
    UUID bookId;
    @JsonProperty
    BookName bookName;
    @JsonProperty
    Isbn isbn;
    @JsonProperty
    Image image;
    @JsonProperty
    Author author;
    @JsonProperty
    ReleaseYear releaseYear;
    @JsonProperty
    Rate rate;
    @JsonProperty
    Language language;
}
