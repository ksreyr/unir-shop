package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.BookRepository;
import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateBookUseCase {
    BookRepository bookRepository;

    public Either<String, Book> createBook(Book book){
        return Either.right(bookRepository.createBook(book));
    }
}
