package com.unir.webdev.books.infrastructure.controllers.DTO.request;

import lombok.With;

@With
public record GetBookByRequest(String search,
                               String releaseYear,
                               String idioma,
                               Boolean aggregate) {


}
