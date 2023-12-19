package com.unir.webdev.orders.infrastructur.persistence.entity.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Embeddable
@NoArgsConstructor(force = true)
public record DateInfo(Instant creationDate) {

}
