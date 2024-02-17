package com.unir.webdev.books.infrastructure.utils;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.valueObjects.Author;
import com.unir.webdev.books.domain.valueObjects.Available;
import com.unir.webdev.books.domain.valueObjects.BookName;
import com.unir.webdev.books.domain.valueObjects.Image;
import com.unir.webdev.books.domain.valueObjects.Isbn;
import com.unir.webdev.books.domain.valueObjects.Language;
import com.unir.webdev.books.domain.valueObjects.Rate;
import com.unir.webdev.books.domain.valueObjects.ReleaseYear;
import com.unir.webdev.books.infrastructure.persistence.BookRepositoryJPA;
import com.unir.webdev.books.infrastructure.persistence.entity.BookEntity;
import com.unir.webdev.books.infrastructure.persistence.mappers.BookMapperPersistence;
import com.unir.webdev.books.infrastructure.searchfilter.inerface.ElasticInterface;
import com.unir.webdev.books.infrastructure.searchfilter.mappers.BookMapper;
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
public class InitialData {
    ElasticInterface elasticInterface;
    BookRepositoryJPA bookRepositoryJPA;
    List<Book> entities = List.of(
            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23fa"),
                    new BookName("Cien años de soledad"),
                    new Isbn("978-0307474728"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Gabriel García " + "Márquez"),
                    new ReleaseYear(1967),
                    new Rate(4.7),
                    new Language("Español"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23fe"),
                    new BookName("1984"),
                    new Isbn("978-0451524935"),
                    new Image("http://thecatapi" + ".com/api/images/get" + "?format" +
                              "=src&type" + "=gif"),
                    new Author("George Orwell"),
                    new ReleaseYear(1949),
                    new Rate(4.6),
                    new Language("Inglés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e3405b2d-ecc0-4e78-aacd-f85b7a5d23fe"),
                    new BookName("El Principito"),
                    new Isbn("978-0156012195"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type" +
                              "=gif"),
                    new Author("Antoine de" + " " + "Saint-Exup" + "éry"),
                    new ReleaseYear(1943),
                    new Rate(4.7),
                    new Language("Francés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7345b2d-ecc0-4e78-aacd-f85b7a5d23fe"),
                    new BookName("Moby Dick"),
                    new Isbn("978-1503280786"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type" +
                              "=gif"),
                    new Author("Herman Melville"),
                    new ReleaseYear(1851),
                    new Rate(4.5),
                    new Language("Inglés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23f4"),
                    new BookName("Crónica de una muerte anunciada"),
                    new Isbn("978-8439722806"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Gabriel García Márquez"),
                    new ReleaseYear(1981),
                    new Rate(4.6),
                    new Language("Español"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23f2"),
                    new BookName("El nombre del viento"),
                    new Isbn("978-0756404741"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Patrick Rothfuss"),
                    new ReleaseYear(2007),
                    new Rate(4.7),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23f7"),
                    new BookName("Harry Potter y la piedra filosofal"),
                    new Isbn("978-0747532699"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("J.K. Rowling"),
                    new ReleaseYear(1997),
                    new Rate(4.8),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23f8"),
                    new BookName("Tokio blues (Norwegian Wood)"),
                    new Isbn("978-8483835043"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Haruki Murakami"),
                    new ReleaseYear(1987),
                    new Rate(4.5),
                    new Language("Japonés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23f1"),
                    new BookName("La sombra del viento"),
                    new Isbn("978-8408079545"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Carlos Ruiz Zafón"),
                    new ReleaseYear(2001),
                    new Rate(4.7),
                    new Language("Español"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23f0"),
                    new BookName("Los juegos del hambre"),
                    new Isbn("978-0439023481"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Suzanne Collins"),
                    new ReleaseYear(2008),
                    new Rate(4.6),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23fb"),
                    new BookName("El alquimista"),
                    new Isbn("978-0061122415"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Paulo Coelho"),
                    new ReleaseYear(1988),
                    new Rate(4.7),
                    new Language("Portugués"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e4567b2d-ecc0-4e78-aacd-f85b7a5d23fb"),
                    new BookName("Frankenstein"),
                    new Isbn("978-0486282114"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Mary Shelley"),
                    new ReleaseYear(1818),
                    new Rate(4.4),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7376b2d-ecc0-4e78-aacd-f85b7a5d23fb"),
                    new BookName("Fahrenheit 451"),
                    new Isbn("978-1451673319"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Ray Bradbury"),
                    new ReleaseYear(1953),
                    new Rate(4.6),
                    new Language("Inglés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7310b2d-ecc0-4e78-aacd-f85b7a5d23fb"),
                    new BookName("Don Quijote de la Mancha"),
                    new Isbn("978-8467037929"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Miguel de Cervantes"),
                    new ReleaseYear(1605),
                    new Rate(4.6),
                    new Language("Español"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e74-aacd-f85b7a5d23fb"),
                    new BookName("To Kill a " + "Mockingbird"),
                    new Isbn("978-0446310789"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type" +
                              "=gif"),
                    new Author("Harper Lee"),
                    new ReleaseYear(1960),
                    new Rate(4.8),
                    new Language("Inglés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7305b2d-ecc0-1e78-aacd-f85b7a5d23fb"),
                    new BookName("El señor " + "de los " + "anillos"),
                    new Isbn("978-0261103252"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type" +
                              "=gif"),
                    new Author("J.R.R. " + "Tolkien"),
                    new ReleaseYear(1954),
                    new Rate(4.9),
                    new Language("Inglés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d23fb"),
                    new BookName("Siddhartha"),
                    new Isbn("978-0553208849"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Hermann Hesse"),
                    new ReleaseYear(1922),
                    new Rate(4.5),
                    new Language("Alemán"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e23-aacd-f85b7a5d23fb"),
                    new BookName("La metamorfosis"),
                    new Isbn("978-8437604224"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Franz Kafka"),
                    new ReleaseYear(1915),
                    new Rate(4.2),
                    new Language("Alemán"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b4a5d23fb"),
                    new BookName("El guardián entre el centeno"),
                    new Isbn("978-0316769488"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("J.D. Salinger"),
                    new ReleaseYear(1951),
                    new Rate(4.0),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d13fb"),
                    new BookName("Los miserables"),
                    new Isbn("978-8491051121"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Victor Hugo"),
                    new ReleaseYear(1862),
                    new Rate(4.8),
                    new Language("Francés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f85b7a5d27fb"),
                    new BookName("Cumbres Borrascosas"),
                    new Isbn("978-8484283310"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Emily Brontë"),
                    new ReleaseYear(1847),
                    new Rate(4.4),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f95b7a5d23fb"),
                    new BookName("El sol también se levanta"),
                    new Isbn("978-8426403860"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Ernest Hemingway"),
                    new ReleaseYear(1926),
                    new Rate(4.2),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f23b7a5d23fb"),
                    new BookName("La llamada de Cthulhu"),
                    new Isbn("978-8477027024"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("H.P. Lovecraft"),
                    new ReleaseYear(1928),
                    new Rate(4.5),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e78-aacd-f10b7a5d23fb"),
                    new BookName("A sangre fría"),
                    new Isbn("978-8433972996"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Truman Capote"),
                    new ReleaseYear(1966),
                    new Rate(4.6),
                    new Language("Inglés"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e7305b2d-ecc0-4e70-aacd-f85b7a5d23fb"),
                    new BookName("Orgullo y " + "Prejuicio"),
                    new Isbn("978-0141439518"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type" +
                              "=gif"),
                    new Author("Jane Austen"),
                    new ReleaseYear(1813),
                    new Rate(4.6),
                    new Language("Inglés"),
                    new Available(true)));

    @EventListener (ApplicationReadyEvent.class)
    public void persistDataAfterStart() {
        var bookEntityStream = entities.stream()
                                       .map(book -> {
                                           BookEntity bookEntity =
                                                   BookMapperPersistence.fromDomainToDb(book);
                                           com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity bookEntity1 = BookMapper.fromDomainToEla(book);
                                           elasticInterface.save(bookEntity1);
                                           return bookRepositoryJPA.save(bookEntity);
                                       })
                                       .toList();
    }
}
