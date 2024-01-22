package com.unir.webdev.orders.infrastructure.controllers.dto;

import java.util.List;
import java.util.UUID;

public record RequestChangeBookAvailability(List<UUID> booksID) {}
