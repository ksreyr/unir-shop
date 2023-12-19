package com.unir.webdev.orders.application;

import com.unir.webdev.orders.domain.Order;
import com.unir.webdev.orders.domain.repository.OrdersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegisterNewOrderUseCase {

    OrdersRepository ordersRepository;

    public void createNewOder(Order order) {
        ordersRepository.registerNewOrder(order);
    }
}
