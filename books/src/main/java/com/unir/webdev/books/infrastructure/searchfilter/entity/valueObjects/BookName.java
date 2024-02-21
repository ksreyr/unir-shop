package com.unir.webdev.books.infrastructure.searchfilter.entity.valueObjects;



public record BookName(String bookName) {
    @Override
    public String toString() {
        return bookName;
    }
}
