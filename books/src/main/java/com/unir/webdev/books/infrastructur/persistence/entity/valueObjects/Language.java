package com.unir.webdev.books.infrastructur.persistence.entity.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Language(String language) {
}
