package com.unir.webdev.products.infrastructur.controllers;

import com.unir.webdev.products.application.GetAllProductsUseCase;
import com.unir.webdev.products.infrastructur.controllers.DTO.GetAllProductsResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetAllProducts {
    GetAllProductsUseCase getAllProductsUseCase;
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(new GetAllProductsResponse(getAllProductsUseCase.getAllProducts()));
    }
}
