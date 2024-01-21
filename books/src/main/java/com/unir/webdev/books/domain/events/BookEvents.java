package com.unir.webdev.books.domain.events;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BookEvents {
    public void requestBooksCreation(List<UUID> booksID);
}
