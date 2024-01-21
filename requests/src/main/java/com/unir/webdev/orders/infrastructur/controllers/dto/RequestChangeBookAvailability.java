package com.unir.webdev.orders.infrastructur.controllers.dto;

import java.util.List;
import java.util.UUID;

public record RequestChangeBookAvailability(List<UUID> booksID) {}
