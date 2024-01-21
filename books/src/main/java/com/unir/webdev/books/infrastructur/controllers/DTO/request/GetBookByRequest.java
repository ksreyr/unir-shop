package com.unir.webdev.books.infrastructur.controllers.DTO.request;

import lombok.With;

@With
public record GetBookByRequest(String name, String author) {
}
