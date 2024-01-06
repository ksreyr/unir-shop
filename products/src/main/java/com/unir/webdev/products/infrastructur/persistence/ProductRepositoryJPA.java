package com.unir.webdev.products.infrastructur.persistence;

import com.unir.webdev.products.infrastructur.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepositoryJPA extends JpaRepository<ProductEntity, UUID> {
    public List<ProductEntity> findAll();
}
