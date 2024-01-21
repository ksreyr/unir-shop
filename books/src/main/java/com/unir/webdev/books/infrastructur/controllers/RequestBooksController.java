package com.unir.webdev.books.infrastructur.controllers;

import com.unir.webdev.books.application.RequestBookUseCase;
import com.unir.webdev.books.infrastructur.controllers.DTO.request.BooksIdVerificationRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/books")
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class RequestBooksController {
    RequestBookUseCase requestBookUseCase;

    @PostMapping ("/request")
    public ResponseEntity<?> verifyIds(@RequestBody BooksIdVerificationRequest booksIdVerificationRequest) {
        var stringObjectResult = requestBookUseCase.requestBooks(booksIdVerificationRequest.booksID());
        return stringObjectResult.isSuccess() ?
                ResponseEntity.ok(stringObjectResult.getSuccess()) :
                ResponseEntity.badRequest().body(stringObjectResult.getError());
    }
}
