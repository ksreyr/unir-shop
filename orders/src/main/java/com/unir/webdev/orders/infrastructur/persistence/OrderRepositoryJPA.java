package com.unir.webdev.orders.infrastructur.persistence;

import com.unir.webdev.orders.infrastructur.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepositoryJPA extends JpaRepository<Order, UUID> {
}
