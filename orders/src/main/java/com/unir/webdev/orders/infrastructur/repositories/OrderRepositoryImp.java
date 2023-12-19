package com.unir.webdev.orders.infrastructur.repositories;

import com.unir.webdev.orders.domain.Order;
import com.unir.webdev.orders.domain.repository.OrdersRepository;
import com.unir.webdev.orders.infrastructur.persistence.OrderRepositoryJPA;
import com.unir.webdev.orders.infrastructur.persistence.mapper.OrderMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderRepositoryImp implements OrdersRepository {

    OrderRepositoryJPA orderRepositoryJPA;
    OrderMapper orderMapper;

    @Override
    public void registerNewOrder(Order order) {
        orderRepositoryJPA
                .save(orderMapper.adaptDomainToDb(order));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepositoryJPA.findAll()
                .stream()
                .map(orderMapper::adaptDbToDomain)
                .toList();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepositoryJPA
                .delete(orderMapper.adaptDomainToDb(order));
    }
}
