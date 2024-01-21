package com.unir.webdev.books.application;

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
public class ChangeAvailabilityUseCase {
    BookRepository bookRepository;

    public void changeAvailability(List<UUID> booksID){
        bookRepository.changeAvailabilityOf(booksID);
    }
}
