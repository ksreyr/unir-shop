package com.unir.webdev.orders.domain.repository;

import com.unir.webdev.orders.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository {
    void registerNewOrder(Order order);
    List<Order> getAllOrders();
    void deleteOrder(Order order);
}
