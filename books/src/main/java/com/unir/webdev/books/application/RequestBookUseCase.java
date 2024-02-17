package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.events.BookEvents;
import com.unir.webdev.books.domain.repository.BookRepository;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.collection.Traversable;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static io.vavr.control.Either.*;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RequestBookUseCase {
    BookEvents bookEvents;
    BookRepository bookRepository;

    public Either<String, Boolean> requestBooks(List<UUID> books) {
        log.info("gettin service event create request");
        return sequenceRight(books.filter(bookRepository :: isValidBook)
                                  .filter(bookRepository :: areAvailable)
                                  .map(bookRepository :: changeToUnavailability))
                .flatMap(map->sendEvents(map.toList()))
                .map(Traversable :: get);
    }


    private Either<String, Seq<Boolean>> sendEvents(@NonNull List<UUID> books) {
        if(books.isEmpty()){
            return Either.left("Not Empty List");
        }
        return Either.sequenceRight(Try.of(() ->
            bookEvents.requestBooksCreation(books.asJava())
        ).onFailure(throwable -> books.forEach(bookRepository :: changeAvailabilityOf))
                  .toEither("Send Event For Request Books Failed"));
    }
}
