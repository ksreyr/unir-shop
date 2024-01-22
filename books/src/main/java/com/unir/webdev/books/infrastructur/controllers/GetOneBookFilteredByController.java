package com.unir.webdev.books.infrastructur.controllers;

import com.unir.webdev.books.application.GetBookByUseCase;
import com.unir.webdev.books.infrastructur.controllers.DTO.request.GetBookByRequest;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Value
@RestController
@RequiredArgsConstructor
@RequestMapping ("api/v1/books")
@FieldDefaults (makeFinal = true, level = PRIVATE)
public class GetOneBookFilteredByController {
    GetBookByUseCase getBookByUseCase;

    @GetMapping ("/filterBy")
    public ResponseEntity<?> getAProduct(GetBookByRequest request) {
       return Optional.ofNullable(request)
                .filter(GetBookByRequest :: existAuthor)
                .filter(GetBookByRequest :: existBookName)
                .map( getBookByRequest -> getBookByUseCase.getBookBy(request.name(), request.author()))
                .map(books -> ResponseEntity.ok().body(books))
                .orElse(ResponseEntity.badRequest().body(List.of()));
    }

}
