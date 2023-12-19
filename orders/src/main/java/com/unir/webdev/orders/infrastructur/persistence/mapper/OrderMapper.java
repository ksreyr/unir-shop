package com.unir.webdev.orders.infrastructur.persistence.mapper;

import com.unir.webdev.orders.infrastructur.persistence.entity.Order;
import com.unir.webdev.orders.infrastructur.persistence.entity.valueObjects.DateInfo;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order adaptDomainToDb(com.unir.webdev.orders.domain.Order order) {
        return new Order(order.getId(),
                new DateInfo(order.getDateInfo().creationDate()),
                order.getProductsID());
    }
    public com.unir.webdev.orders.domain.Order adaptDbToDomain(Order order) {
        return new com.unir.webdev.orders.domain.Order(order.getId(),
                new com.unir.webdev.orders.domain.valueObjects.DateInfo(order.getDateInfo().creationDate()),
                order.getProductsID());
    }
}
