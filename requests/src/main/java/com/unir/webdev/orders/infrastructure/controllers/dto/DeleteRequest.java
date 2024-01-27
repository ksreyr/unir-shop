package com.unir.webdev.orders.infrastructure.controllers.dto;

import java.util.UUID;

public record DeleteRequest(UUID requestUUID) {
    public boolean isNotNull() {
        return requestUUID != null;
    }
}
