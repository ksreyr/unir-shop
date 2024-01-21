package com.unir.webdev.books.infrastructur.controllers.DTO.request;

import java.util.List;
import java.util.UUID;

public record ChangeAvailabilityRequest(List<UUID> booksID) {}
