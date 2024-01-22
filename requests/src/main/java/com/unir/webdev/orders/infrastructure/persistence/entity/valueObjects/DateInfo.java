package com.unir.webdev.orders.infrastructure.persistence.entity.valueObjects;

import jakarta.persistence.Embeddable;

import java.time.Instant;


@Embeddable
public record DateInfo(Instant creationDate) {

}
