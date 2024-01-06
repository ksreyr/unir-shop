package com.unir.webdev.products.infrastructur.repositories;

import com.unir.webdev.products.domain.Product;
import com.unir.webdev.products.domain.repository.ProductRepository;
import com.unir.webdev.products.infrastructur.persistence.ProductRepositoryJPA;
import com.unir.webdev.products.infrastructur.persistence.mappers.ProductMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductRepositoryImp implements ProductRepository {
    ProductRepositoryJPA productRepositoryJPA;
    @Override
    public void select(Product product) {
    }

    @Override
    public Optional<List<Product>> getSelectedProducts(Product product) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryJPA
                .findAll()
                .stream()
                .map(ProductMapper::fromDbToDomain)
                .toList();
    }
}
