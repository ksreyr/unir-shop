package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.repository.BookRepository;
import com.unir.webdev.books.domain.response.Result;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class ChangeAvailabilityUseCase {
    BookRepository bookRepository;

    public Result<String, Object> changeAvailability(List<UUID> booksID) {
        return booksID.stream()
                      .filter(bookRepository :: isValidBook)
                      .map(this :: changeAvailabilityOf)
                      .allMatch(Result :: isSuccess) ? Result.success("all changed") :
               Result.error("Error change");
    }

    private @NotNull Result<String, Object> changeAvailabilityOf(UUID uuids) {
        bookRepository.changeAvailabilityOf(uuids); return Result.success("change");
    }
}
