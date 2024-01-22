package com.unir.webdev.books.infrastructure.controllers;

import com.unir.webdev.books.application.ChangeAvailabilityUseCase;
import com.unir.webdev.books.domain.response.Result;
import com.unir.webdev.books.infrastructure.controllers.DTO.request.ChangeAvailabilityRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/v1/books")
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class ChangeAvailabilityBookController {
    ChangeAvailabilityUseCase changeAvailabilityUseCase;

    @PostMapping ("/changeAvailability")
    public ResponseEntity<?> handle(@RequestBody ChangeAvailabilityRequest changeAvailabilityRequest) {
        return Optional.ofNullable(changeAvailabilityRequest)
                       .filter(ChangeAvailabilityRequest :: existBooks)
                       .map(ChangeAvailabilityRequest :: booksID)
                       .map(changeAvailabilityUseCase :: changeAvailability)
                       .map(ChangeAvailabilityBookController :: buildResponse)
                       .orElse(ResponseEntity.badRequest()
                                                      .body("Bad Request given "));
    }

    @NotNull
    private static ResponseEntity<Object> buildResponse(Result<String, Object> stringObjectsResult) {
        return stringObjectsResult.isSuccess() ?
               ResponseEntity.ok(stringObjectsResult.getSuccess()) :
               ResponseEntity.badRequest()
                             .body(stringObjectsResult.getError());
    }
}
