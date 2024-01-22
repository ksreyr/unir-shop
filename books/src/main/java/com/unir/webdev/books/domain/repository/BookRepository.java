package com.unir.webdev.books.domain.repository;

import com.unir.webdev.books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository {

    List<Book> getAllProducts();
    List<Book> getAllProductsBy(String name, String author);
    Boolean areValidBooks(List<UUID> booksID);
    void changeUnavailabilityOf(List<UUID> books);
    void changeAvailabilityOf(List<UUID> books);
    boolean areAvailable(List<UUID> books);
}
