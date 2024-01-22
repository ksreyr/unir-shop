package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.events.BookEvents;
import com.unir.webdev.books.domain.repository.BookRepository;
import com.unir.webdev.books.domain.response.Result;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestBookUseCase {
    BookEvents bookEvents;
    BookRepository bookRepository;

    public Result<String, Object> requestBooks(List<UUID> books) {
        return Optional.of(books.stream()
                         .filter(bookRepository::isValidBook)
                         .filter(bookRepository::areAvailable)
                         .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty())
                .map(this::sendEvents)
                .orElse(Result.error("Bad Request"));
    }

    @NotNull
    private Result<String, Object> sendEvents(List<UUID> books) {
        bookEvents.requestBooksCreation(books);
        bookRepository.changeUnavailabilityOf(books);
        return Result.success("Request done");
    }
}
