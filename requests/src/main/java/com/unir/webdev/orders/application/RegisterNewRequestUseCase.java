package com.unir.webdev.orders.application;

import com.unir.webdev.orders.domain.Request;
import com.unir.webdev.orders.domain.repository.RequestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegisterNewRequestUseCase {

    RequestRepository requestRepository;

    public void createNewOder(List<UUID> request) {
        requestRepository.registerNewOrder(Request.of(request));
    }


}
