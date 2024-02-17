package com.unir.webdev.orders.application;

import com.unir.webdev.orders.domain.Request;
import com.unir.webdev.orders.domain.repository.RequestRepository;
import com.unir.webdev.orders.domain.response.Result;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults (makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class RegisterNewRequestUseCase {

    RequestRepository requestRepository;

    public Result<String, Object> createNewOder(List<UUID> request) {
        log.info("service create new order");
        requestRepository.registerNewOrder(Request.of(request));
        return Result.success("registerNewOrder");
    }


}
