package com.unir.webdev.orders.infrastructur.controllers;

import com.unir.webdev.orders.application.RegisterNewOrderUseCase;
import com.unir.webdev.orders.infrastructur.controllers.dto.OrderRequest;
import com.unir.webdev.orders.infrastructur.controllers.mappers.OrderRequestMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegisterNewOrderController {
    RegisterNewOrderUseCase registerNewOrderUseCase;
    OrderRequestMapper orderRequestMapper;

    @PostMapping("/creation")
    public ResponseEntity<?> handel(
            @RequestBody OrderRequest orderRequest
    ) {
        registerNewOrderUseCase.createNewOder(orderRequestMapper.orderRequestToDomain(orderRequest));
        return ResponseEntity.ok("");
    }
    @GetMapping
    public ResponseEntity<?> healthCheck(){
        return ResponseEntity.ok("ok");
    }
}
