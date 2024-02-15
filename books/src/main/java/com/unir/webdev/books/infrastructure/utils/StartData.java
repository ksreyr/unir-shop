package com.unir.webdev.books.infrastructure.utils;

import com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Author;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Available;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.BookName;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Image;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Isbn;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Language;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.Rate;
import com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects.ReleaseYear;
import com.unir.webdev.books.infrastructure.searchfilter.entity.inerface.ElastikInterface;
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
    ElastikInterface bookRepositoryJPA;

    @EventListener (ApplicationReadyEvent.class)
    public void persistDataAfterStart() {
        bookRepositoryJPA.saveAll(List.of(
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Cien años de " + "soledad"),
                        new Isbn("978-0307474728"),
                        new Image("http://thecatapi" + ".com/api/images/get" + "?format" +
                                  "=src&type" + "=gif"),
                        new Author("Gabriel García " + "Márquez"),
                        new ReleaseYear(1967),
                        new Rate(4.7),
                        new Language("Español"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("1984"),
                        new Isbn("978-0451524935"),
                        new Image("http://thecatapi" + ".com/api/images/get" + "?format" +
                                  "=src&type" + "=gif"),
                        new Author("George Orwell"),
                        new ReleaseYear(1949),
                        new Rate(4.6),
                        new Language("Inglés"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("El Principito"),
                        new Isbn("978-0156012195"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type" +
                                  "=gif"),
                        new Author("Antoine de" + " " + "Saint-Exup" + "éry"),
                        new ReleaseYear(1943),
                        new Rate(4.7),
                        new Language("Francés"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Moby Dick"),
                        new Isbn("978-1503280786"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type" +
                                  "=gif"),
                        new Author("Herman Melville"),
                        new ReleaseYear(1851),
                        new Rate(4.5),
                        new Language("Inglés"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Crónica de una muerte anunciada"),
                        new Isbn("978-8439722806"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Gabriel García Márquez"),
                        new ReleaseYear(1981),
                        new Rate(4.6),
                        new Language("Español"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("El nombre del viento"),
                        new Isbn("978-0756404741"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Patrick Rothfuss"),
                        new ReleaseYear(2007),
                        new Rate(4.7),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Harry Potter y la piedra filosofal"),
                        new Isbn("978-0747532699"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("J.K. Rowling"),
                        new ReleaseYear(1997),
                        new Rate(4.8),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Tokio blues (Norwegian Wood)"),
                        new Isbn("978-8483835043"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Haruki Murakami"),
                        new ReleaseYear(1987),
                        new Rate(4.5),
                        new Language("Japonés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("La sombra del viento"),
                        new Isbn("978-8408079545"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Carlos Ruiz Zafón"),
                        new ReleaseYear(2001),
                        new Rate(4.7),
                        new Language("Español"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Los juegos del hambre"),
                        new Isbn("978-0439023481"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Suzanne Collins"),
                        new ReleaseYear(2008),
                        new Rate(4.6),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("El alquimista"),
                        new Isbn("978-0061122415"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Paulo Coelho"),
                        new ReleaseYear(1988),
                        new Rate(4.7),
                        new Language("Portugués"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Frankenstein"),
                        new Isbn("978-0486282114"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Mary Shelley"),
                        new ReleaseYear(1818),
                        new Rate(4.4),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Fahrenheit 451"),
                        new Isbn("978-1451673319"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Ray Bradbury"),
                        new ReleaseYear(1953),
                        new Rate(4.6),
                        new Language("Inglés"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Don Quijote de la Mancha"),
                        new Isbn("978-8467037929"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Miguel de Cervantes"),
                        new ReleaseYear(1605),
                        new Rate(4.6),
                        new Language("Español"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("To Kill a " + "Mockingbird"),
                        new Isbn("978-0446310789"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type" +
                                  "=gif"),
                        new Author("Harper Lee"),
                        new ReleaseYear(1960),
                        new Rate(4.8),
                        new Language("Inglés"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("El señor " + "de los " + "anillos"),
                        new Isbn("978-0261103252"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type" +
                                  "=gif"),
                        new Author("J.R.R. " + "Tolkien"),
                        new ReleaseYear(1954),
                        new Rate(4.9),
                        new Language("Inglés"),
                        new Available(true)),
                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Siddhartha"),
                        new Isbn("978-0553208849"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Hermann Hesse"),
                        new ReleaseYear(1922),
                        new Rate(4.5),
                        new Language("Alemán"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("La metamorfosis"),
                        new Isbn("978-8437604224"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Franz Kafka"),
                        new ReleaseYear(1915),
                        new Rate(4.2),
                        new Language("Alemán"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("El guardián entre el centeno"),
                        new Isbn("978-0316769488"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("J.D. Salinger"),
                        new ReleaseYear(1951),
                        new Rate(4.0),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Los miserables"),
                        new Isbn("978-8491051121"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Victor Hugo"),
                        new ReleaseYear(1862),
                        new Rate(4.8),
                        new Language("Francés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Cumbres Borrascosas"),
                        new Isbn("978-8484283310"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Emily Brontë"),
                        new ReleaseYear(1847),
                        new Rate(4.4),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("El sol también se levanta"),
                        new Isbn("978-8426403860"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Ernest Hemingway"),
                        new ReleaseYear(1926),
                        new Rate(4.2),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("La llamada de Cthulhu"),
                        new Isbn("978-8477027024"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("H.P. Lovecraft"),
                        new ReleaseYear(1928),
                        new Rate(4.5),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("A sangre fría"),
                        new Isbn("978-8433972996"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                        new Author("Truman Capote"),
                        new ReleaseYear(1966),
                        new Rate(4.6),
                        new Language("Inglés"),
                        new Available(true)),

                new BookEntity(
                        UUID.randomUUID(),
                        new BookName("Orgullo y " + "Prejuicio"),
                        new Isbn("978-0141439518"),
                        new Image("http://thecatapi.com/api/images/get?format=src&type" +
                                  "=gif"),
                        new Author("Jane Austen"),
                        new ReleaseYear(1813),
                        new Rate(4.6),
                        new Language("Inglés"),
                        new Available(true))));
    }
}
