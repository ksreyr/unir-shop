package com.unir.webdev.orders.infrastructur.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/request")
public class HealthCheckController {
    @GetMapping
    public ResponseEntity<?> healthCheck(){
        return ResponseEntity.ok("ok");
    }
}
