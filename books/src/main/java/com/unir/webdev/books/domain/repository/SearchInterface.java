package com.unir.webdev.books.domain.repository;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.infrastructure.repositories.DTO.BooksResponse;
import io.vavr.control.Either;

import java.util.List;

public interface SearchInterface {
    BooksResponse buildResponse(String search, String anoPublicacion, Boolean aggregate);
    List<Book> getAllBooks();
    List<Book> getBookBy(String search, String anoPublicacion, Boolean aggregate);

    List<Book> getBookBy(String name, String author);

    Either<String, Book> updateBook(Book book);
}
