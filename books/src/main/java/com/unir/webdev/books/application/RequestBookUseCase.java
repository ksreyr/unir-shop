package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.DTO.Result;
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
        if( !bookRepository.areValidateIDs(books)) {
            return  Result.error("Unknown Data");
        }
        bookEvents.requestBooksCreation(books);
        return Result.success("Data Persisted");
    }
}
