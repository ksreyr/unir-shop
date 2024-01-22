package com.unir.webdev.books.infrastructure.controllers;

import com.unir.webdev.books.application.GetAllBooksUseCase;
import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.response.Result;
import com.unir.webdev.books.infrastructure.controllers.DTO.GetAllBooksResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetAllBooksController {
    GetAllBooksUseCase getAllBooksUseCase;
    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
        Result<List<Book>, Object> allProducts = getAllBooksUseCase.getAllProducts();
        return  (allProducts.isSuccess())?
                ResponseEntity.ok(new GetAllBooksResponse(allProducts.getSuccess())):
                ResponseEntity.badRequest().body("Not permitted process");
    }
}
