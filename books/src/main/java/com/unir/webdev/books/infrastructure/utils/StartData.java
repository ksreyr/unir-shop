package com.unir.webdev.books.infrastructure.utils;

import com.unir.webdev.books.infrastructure.persistence.BookRepositoryJPA;
import com.unir.webdev.books.infrastructure.persistence.entity.BookEntity;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Author;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Available;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.BookName;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Image;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Isbn;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Language;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.Rate;
import com.unir.webdev.books.infrastructure.persistence.entity.valueObjects.ReleaseYear;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class StartData {
    BookRepositoryJPA bookRepositoryJPA;

    @EventListener (ApplicationReadyEvent.class)
    public void persistDataAfterStart() {
        bookRepositoryJPA.saveAll(List.of(new BookEntity(UUID.randomUUID(),
                                                         new BookName("Cien años de " +
                                                                      "soledad"),
                                                         new Isbn("978-0307474728"),
                                                         new Image("http://thecatapi" +
                                                                   ".com/api/images/get" +
                                                                   "?format=src&type" +
                                                                   "=gif"),
                                                         new Author("Gabriel García " + "Márquez"),
                                                         new ReleaseYear(1967),
                                                         new Rate(4.7),
                                                         new Language("Español"),
                                                         new Available(true)),
                                          new BookEntity(UUID.randomUUID(),
                                                         new BookName("1984"),
                                                         new Isbn("978-0451524935"),
                                                         new Image("http://thecatapi" +
                                                                   ".com/api/images/get" +
                                                                   "?format=src&type" +
                                                                   "=gif"),
                                                         new Author("George Orwell"),
                                                         new ReleaseYear(1949),
                                                         new Rate(4.6),
                                                         new Language("Inglés"),
                                                         new Available(true)),
                                          new BookEntity(
                                                  UUID.randomUUID(),
                                                  new BookName("El Principito"),
                                                  new Isbn("978-0156012195"),
                                                  new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                                                  new Author("Antoine de" + " " +
                                                             "Saint-Exup" + "éry"),
                                                  new ReleaseYear(1943),
                                                  new Rate(4.7),
                                                  new Language("Francés"),
                                                  new Available(true)),
                                          new BookEntity(UUID.randomUUID(),
                                                         new BookName("To Kill a " +
                                                                      "Mockingbird"),
                                                         new Isbn("978-0446310789"),
                                                         new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                                                         new Author("Harper Lee"),
                                                         new ReleaseYear(1960),
                                                         new Rate(4.8),
                                                         new Language("Inglés"),
                                                         new Available(true)),
                                          new BookEntity(
                                                  UUID.randomUUID(),
                                                  new BookName("El señor " + "de los " + "anillos"),
                                                  new Isbn("978-0261103252"),
                                                  new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                                                  new Author("J.R.R. " + "Tolkien"),
                                                  new ReleaseYear(1954),
                                                  new Rate(4.9),
                                                  new Language("Inglés"),
                                                  new Available(true)),
                                          new BookEntity(UUID.randomUUID(),
                                                         new BookName("Orgullo y " +
                                                                      "Prejuicio"),
                                                         new Isbn("978-0141439518"),
                                                         new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                                                         new Author("Jane Austen"),
                                                         new ReleaseYear(1813),
                                                         new Rate(4.6),
                                                         new Language("Inglés"),
                                                         new Available(true))));
    }
}
