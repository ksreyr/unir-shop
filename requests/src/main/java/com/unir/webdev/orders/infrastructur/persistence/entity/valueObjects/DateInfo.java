package com.unir.webdev.orders.infrastructur.persistence.entity.valueObjects;

import jakarta.persistence.Embeddable;

import java.time.Instant;


@Embeddable
public record DateInfo(Instant creationDate) {

}
