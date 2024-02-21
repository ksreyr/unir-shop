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
                    UUID.fromString("10567d88-a219-4112-be85-3d6a5614489a"),
                    new BookName("To Kill a Mockingbird"),
                    new Isbn("978-0061120084"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Harper Lee"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("a5e125cb-5dbe-4500-b94c-63993c96f49f"),
                    new BookName("1984"),
                    new Isbn("978-0451524935"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("George Orwell"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("6c727b84-22f4-4b74-a67e-bb5763831704"),
                    new BookName("The Great Gatsby"),
                    new Isbn("978-0743273565"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("F. Scott Fitzgerald"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("c0b85ec8-7e10-4adb-b0f9-541f7d9f529a"),
                    new BookName("One Hundred Years of Solitude"),
                    new Isbn("978-0060883287"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Gabriel García Márquez"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("59ae58fe-2ee3-47d9-a607-e241b1d32f1b"),
                    new BookName("Pride and Prejudice"),
                    new Isbn("978-1503290563"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Jane Austen"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("6ad80924-2027-424d-b2ae-b9287926c4cd"),
                    new BookName("The Catcher in the Rye"),
                    new Isbn("978-0316769488"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("J.D. Salinger"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("6694d19e-89b2-4871-b410-2972cb6f1e87"),
                    new BookName("Crime and Punishment"),
                    new Isbn("978-0486415871"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Fyodor Dostoevsky"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("0b76f6b4-0da1-40ea-9d08-fda14bb12034"),
                    new BookName("Wuthering Heights"),
                    new Isbn("978-1853264887"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Emily Brontë"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("1c607f4d-d9a9-4bfe-9443-fcb186e6078b"),
                    new BookName("Les Misérables"),
                    new Isbn("978-0140449266"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Victor Hugo"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("28147ccd-be80-475a-9b55-0a1b335b4dec"),
                    new BookName("War and Peace"),
                    new Isbn("978-0199232765"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Leo Tolstoy"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("0baf0e8d-5447-48d5-be06-194da181838c"),
                    new BookName("The Brothers Karamazov"),
                    new Isbn("978-0374528379"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Fyodor Dostoevsky"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("78bcfd41-980e-489b-9900-824e0e382ef5"),
                    new BookName("Moby-Dick"),
                    new Isbn("978-0142437247"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Herman Melville"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),

            new Book(
                    UUID.fromString("e59adcde-30f7-46e0-a061-a885442b9d54"),
                    new BookName("The Odyssey"),
                    new Isbn("978-0140268867"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Homer"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("8892346f-df67-48fb-a8c3-0d3a57d2864d"),
                    new BookName("The Divine Comedy"),
                    new Isbn("978-0140448955"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Dante Alighieri"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("d4a19d8d-ac9f-4a4e-9455-262acc8dd439"),
                    new BookName("Madame Bovary"),
                    new Isbn("978-0140449129"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Gustave Flaubert"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("db773aee-6164-4416-963a-c051d1fede05"),
                    new BookName("The Adventures of Huckleberry Finn"),
                    new Isbn("978-0486400778"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Mark Twain"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("dc1e1159-c142-4744-aea3-247d29421459"),
                    new BookName("The Iliad"),
                    new Isbn("978-0140275360"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Homer"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("95ff9be8-3585-4c84-bf63-be3ca409b501"),
                    new BookName("Don Quixote"),
                    new Isbn("978-0060934347"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Miguel de Cervantes"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("fc790315-e46d-4022-9b65-4bc1774308b9"),
                    new BookName("The Republic"),
                    new Isbn("978-0872207363"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Plato"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),
            new Book(
                    UUID.fromString("5c1629ef-10cb-4a10-aa4b-6e008776a67a"),
                    new BookName("Jane Eyre"),
                    new Isbn("978-0141441146"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Charlotte Brontë"),
                    new ReleaseYear(2020),
                    new Rate(4.5),
                    new Language("English"),
                    new Available(true)),

            new Book(
                    UUID.fromString("6cf6c362-38db-43d6-a46c-7e2272895e57"),
                    new BookName("El Señor de los Anillos"),
                    new Isbn("978-149-0177588"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Paulo Coelho"),
                    new ReleaseYear(1935),
                    new Rate(4.5),
                    new Language("Francés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("cab95c61-0c6d-439f-8d88-b93c997277ae"),
                    new BookName("El Alquimista"),
                    new Isbn("978-110-0781532"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Antoine de Saint-Exupéry"),
                    new ReleaseYear(1998),
                    new Rate(4.1),
                    new Language("Ruso"),
                    new Available(true)),
            new Book(
                    UUID.fromString("03cfe9c0-209c-4c53-99a4-b9ce2ccbbf19"),
                    new BookName("Orgullo y Prejuicio"),
                    new Isbn("978-037-0188920"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Antoine de Saint-Exupéry"),
                    new ReleaseYear(2000),
                    new Rate(4.8),
                    new Language("Ruso"),
                    new Available(true)),
            new Book(
                    UUID.fromString("72c68ff0-c055-4bc1-8cf7-7888182e23e4"),
                    new BookName("Cien años de soledad"),
                    new Isbn("978-037-0285029"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Antoine de Saint-Exupéry"),
                    new ReleaseYear(1967),
                    new Rate(4.4),
                    new Language("Italiano"),
                    new Available(true)),
            new Book(
                    UUID.fromString("115fb0c8-ea1f-4a3d-bda7-b67da6510fbc"),
                    new BookName("El Principito"),
                    new Isbn("978-037-0793347"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Gabriel García Márquez"),
                    new ReleaseYear(1928),
                    new Rate(4.0),
                    new Language("Ruso"),
                    new Available(true)),
            new Book(
                    UUID.fromString("d892441f-b338-420e-9d26-3aba9f5b27e9"),
                    new BookName("Harry Potter"),
                    new Isbn("978-030-0354423"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Antoine de Saint-Exupéry"),
                    new ReleaseYear(1974),
                    new Rate(3.8),
                    new Language("Italiano"),
                    new Available(true)),
            new Book(
                    UUID.fromString("b0494b2c-8845-47e2-89e2-e748a8257aba"),
                    new BookName("La Sombra del Viento"),
                    new Isbn("978-014-0648049"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Jane Austen"),
                    new ReleaseYear(1968),
                    new Rate(4.0),
                    new Language("Chino"),
                    new Available(true)),
            new Book(
                    UUID.fromString("56593dab-40a1-4851-b397-480c18316ee6"),
                    new BookName("Crónica de una muerte anunciada"),
                    new Isbn("978-052-0958263"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Antoine de Saint-Exupéry"),
                    new ReleaseYear(1968),
                    new Rate(3.5),
                    new Language("Inglés"),
                    new Available(true)),
            new Book(
                    UUID.fromString("dd7dcb95-7b0e-4806-9ab1-b7e8b7880a1d"),
                    new BookName("Matar a un ruiseñor"),
                    new Isbn("978-052-0268224"),
                    new Image("http://thecatapi.com/api/images/get?format=src&type=gif"),
                    new Author("Carlos Ruiz Zafón"),
                    new ReleaseYear(1946),
                    new Rate(4.8),
                    new Language("Japonés"),
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
