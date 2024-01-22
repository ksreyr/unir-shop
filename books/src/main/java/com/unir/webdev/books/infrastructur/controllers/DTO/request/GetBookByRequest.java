package com.unir.webdev.books.infrastructur.controllers.DTO.request;

import lombok.With;

@With
public record GetBookByRequest(String name, String author) {
    public static boolean existAuthor(GetBookByRequest getBookByRequest) {
        return getBookByRequest.author() != null;
    }

    public static boolean existBookName(GetBookByRequest getBookByRequest) {
        return getBookByRequest.name() != null;
    }
}
