package com.unir.webdev.books.infrastructur.controllers;

import com.unir.webdev.books.application.IdVerficationUseCase;
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
@RequestMapping("api/v1/books")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VerifyBooksIDController {
    IdVerficationUseCase idVerficationUseCase;
    @PostMapping("/verify")
    public ResponseEntity<?> verifyIds(@RequestBody BooksIdVerificationRequest booksIdVerificationRequest){
        Boolean verify = idVerficationUseCase.verify(booksIdVerificationRequest.booksID());
        return ResponseEntity.ok(verify);
    }
}
