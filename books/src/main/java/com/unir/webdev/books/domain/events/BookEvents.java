package com.unir.webdev.books.domain.events;

import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BookEvents {
    Either<String, Boolean> requestBooksCreation(List<UUID> booksID);
}
