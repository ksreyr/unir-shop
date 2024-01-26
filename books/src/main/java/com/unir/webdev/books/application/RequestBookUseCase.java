package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.events.BookEvents;
import com.unir.webdev.books.domain.repository.BookRepository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestBookUseCase {
    BookEvents bookEvents;
    BookRepository bookRepository;

    public Either<String, Boolean> requestBooks(List<UUID> books) {
        if (! isValidData(books)) {return Either.left("No valid Data");}
        if (books.map(bookRepository :: changeToUnavailability)
                 .exists(Either :: isLeft))
        {return Either.left("Error change Availability");}
        return sendEvents(books);
    }

    @NotNull
    private BiFunction<Either<Object, Object>, Either<Object, UUID>, Either<Object,
            Object>> getError() {
        return (acc, object) -> acc.isLeft() ? acc : object.isLeft() ? Either.left(
                "impossible change availability") : Either.right("");
    }

    private boolean isValidData(List<UUID> books) {
        return ! books.filter(bookRepository :: isValidBook)
                      .filter(bookRepository :: areAvailable)
                      .isEmpty();
    }

    private Either<String, Boolean> sendEvents(List<UUID> books) {
        return Try.of(() -> bookEvents.requestBooksCreation(books.asJava()))
                  .onFailure(throwable -> books.forEach(bookRepository :: changeAvailabilityOf))
                  .toEither("Create Event Failed");
    }
}
