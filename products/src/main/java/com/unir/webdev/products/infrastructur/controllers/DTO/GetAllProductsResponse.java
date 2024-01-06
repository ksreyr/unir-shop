package com.unir.webdev.products.infrastructur.controllers.DTO;

import com.unir.webdev.products.domain.Product;

import java.util.List;

public record GetAllProductsResponse(List<Product> products) {

}
