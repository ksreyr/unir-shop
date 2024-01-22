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

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestBookUseCase {
    BookEvents bookEvents;
    BookRepository bookRepository;
    public Result<String, Object> requestBooks(List<UUID> books) {
        return Optional.ofNullable(books)
                       .filter(bookRepository :: areValidBooks)
                       .filter(bookRepository :: areAvailable)
                       .map(this :: sendEvents)
                       .orElse(Result.error("Action Not Possible"));
    }

    @NotNull
    private Result<String, Object> sendEvents(List<UUID> books) {
        bookEvents.requestBooksCreation(books);
        bookRepository.changeUnavailabilityOf(books);
        return Result.success("Request done");
    }
}
