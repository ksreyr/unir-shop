package com.unir.webdev.orders.infrastructur.controllers.mappers;

import com.unir.webdev.orders.domain.Order;
import com.unir.webdev.orders.infrastructur.controllers.dto.OrderRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class OrderRequestMapper {
    public Order orderRequestToDomain(OrderRequest orderRequest) {
        return Order.of(orderRequest.productsList());
    }
}
