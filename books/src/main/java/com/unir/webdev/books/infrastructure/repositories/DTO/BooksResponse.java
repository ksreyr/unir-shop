package com.unir.webdev.books.infrastructure.repositories.DTO;

import com.unir.webdev.books.domain.Book;

import java.util.List;

public record BooksResponse(List<Book> books, List<AggretorDetails> aggretorDetails) {}
