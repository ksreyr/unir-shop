package com.unir.webdev.books.infrastructure.events.DTO;

import java.util.List;
import java.util.UUID;

public record RequestCreation(List<UUID> booksID) {}
