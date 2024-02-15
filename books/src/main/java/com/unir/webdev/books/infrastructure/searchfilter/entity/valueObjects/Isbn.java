package com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Isbn(String isbn) {}
