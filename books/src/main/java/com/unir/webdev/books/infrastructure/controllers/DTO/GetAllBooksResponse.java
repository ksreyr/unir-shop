package com.unir.webdev.books.infrastructure.controllers.DTO;

import com.unir.webdev.books.domain.Book;

import java.util.List;

public record GetAllBooksResponse(List<Book> books) {

}
