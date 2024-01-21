package com.unir.webdev.books.infrastructur.controllers;

import com.unir.webdev.books.application.GetAllBooksUseCase;
import com.unir.webdev.books.infrastructur.controllers.DTO.GetAllBooksResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetAllBooksController {
    GetAllBooksUseCase getAllBooksUseCase;
    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(new GetAllBooksResponse(getAllBooksUseCase.getAllProducts()));
    }
}
