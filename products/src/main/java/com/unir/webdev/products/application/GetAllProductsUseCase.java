package com.unir.webdev.products.application;

import com.unir.webdev.products.domain.Product;
import com.unir.webdev.products.domain.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetAllProductsUseCase {
    ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }
}
