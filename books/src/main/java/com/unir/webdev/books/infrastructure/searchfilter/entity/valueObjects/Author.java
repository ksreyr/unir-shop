package com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects;

public record Author(String author) {
    @Override
    public String toString() {
        return author;
    }
}
