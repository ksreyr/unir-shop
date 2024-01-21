package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.response.Result;
import com.unir.webdev.books.domain.events.BookEvents;
import com.unir.webdev.books.domain.repository.BookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestBookUseCase {
    BookEvents bookEvents;
    BookRepository bookRepository;
    public Result<String, Object> requestBooks(List<UUID> books){
        if( !bookRepository.areValidateIDs(books) || !bookRepository.areAvailable(books)) {
            return  Result.error("Action Not Possible");
        }
        bookEvents.requestBooksCreation(books);
        bookRepository.changeUnavailabilityOf(books);
        return Result.success("Request done");
    }
}
