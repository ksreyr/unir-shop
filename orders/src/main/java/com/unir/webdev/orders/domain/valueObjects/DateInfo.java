package com.unir.webdev.orders.domain.valueObjects;

import java.time.Instant;


public record DateInfo(Instant creationDate) {
    public static DateInfo of() {
        return new DateInfo(Instant.now());
    }
}
