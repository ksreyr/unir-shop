package com.unir.webdev.books.domain.repository;

import com.unir.webdev.books.domain.Book;
import io.vavr.control.Either;

import java.util.List;

public interface SearchInterface {
    List<Book> getAllBooks();
    List<Book> getBooksBy(String search, String anoPublicacion, String idioma, Boolean aggregate);

    List<Book> getBooksBy(String name, String author);

    Either<String, Book> updateBook(Book book);
}
