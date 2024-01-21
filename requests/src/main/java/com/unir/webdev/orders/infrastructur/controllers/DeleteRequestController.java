package com.unir.webdev.orders.infrastructur.controllers;

import com.unir.webdev.orders.application.DeleteRequestsUseCase;
import com.unir.webdev.orders.infrastructur.controllers.dto.DeleteRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/requests")
@RequiredArgsConstructor
@FieldDefaults (makeFinal = true, level = AccessLevel.PRIVATE)
public class DeleteRequestController {
    DeleteRequestsUseCase deleteRequestsUseCase;

    @DeleteMapping
    public ResponseEntity<?> deleteRequest(DeleteRequest deleteRequest) {
        return Optional.ofNullable(deleteRequest)
                       .filter(DeleteRequest :: isNotNull)
                       .map(requestToDelete -> deleteRequestsUseCase.deleteRequest(requestToDelete.requestUUID()))
                       .map(stringStringResult -> {
                           if (stringStringResult.isSuccess()) {
                               return ResponseEntity.ok(stringStringResult.getSuccess());
                           } return ResponseEntity.badRequest()
                                                  .body(stringStringResult.getError());
                       })
                       .orElseGet(() -> ResponseEntity.badRequest()
                                                      .body("Bad Resquest"));

    }
}
