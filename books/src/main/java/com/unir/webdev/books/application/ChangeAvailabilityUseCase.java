package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.repository.BookRepository;
import com.unir.webdev.books.domain.response.Result;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class ChangeAvailabilityUseCase {
    BookRepository bookRepository;

    public Result<String, Object> changeAvailability(List<UUID> booksID) {
        return Optional.ofNullable(booksID)
                .filter(bookRepository :: areValidBooks)
                .map(uuids -> {
                    bookRepository.changeAvailabilityOf(uuids);
                    return Result.success("saved");
                }).orElse(Result.error("Not Valid Data"));
    }
}
