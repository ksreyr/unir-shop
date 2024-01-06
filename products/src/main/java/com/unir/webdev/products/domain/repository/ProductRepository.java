package com.unir.webdev.products.domain.repository;

import com.unir.webdev.products.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {
    void select(Product product);
    Optional<List<Product>> getSelectedProducts(Product product);

    List<Product> getAllProducts();
}
