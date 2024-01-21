package com.unir.webdev.orders.infrastructur.controllers;

import com.unir.webdev.orders.application.RegisterNewRequestUseCase;
import com.unir.webdev.orders.infrastructur.controllers.dto.RequestCreation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/requests")
@RequiredArgsConstructor
@FieldDefaults (makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateRequestController {
    RegisterNewRequestUseCase registerNewRequestUseCase;

    @PostMapping ("/create")
    public ResponseEntity<?> handel(@RequestBody RequestCreation requestCreation) {
        registerNewRequestUseCase.createNewOder(requestCreation.booksID());
        return ResponseEntity.ok("");
    }

}
