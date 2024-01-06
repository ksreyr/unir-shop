package com.unir.webdev.products.infrastructur.persistence.entity.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ImageEntity(String url) {
}
