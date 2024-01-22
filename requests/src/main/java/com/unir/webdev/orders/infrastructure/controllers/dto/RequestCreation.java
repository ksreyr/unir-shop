package com.unir.webdev.orders.infrastructure.controllers.dto;

import java.util.List;
import java.util.UUID;

public record RequestCreation(List<UUID> booksID) {

}
