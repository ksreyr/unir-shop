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
        var productBy = getBookByUseCase.getBookBy(request.name(), request.author());
        return ResponseEntity.ok().body(productBy);
    }
}
