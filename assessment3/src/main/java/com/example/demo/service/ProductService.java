package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductSearchResponse;

@Service
public class ProductService {

    private final List<ProductSearchResponse> products = new ArrayList<>();

    public ProductService() {
        products.add(new ProductSearchResponse(1L, "Laptop", "Electronics"));
        products.add(new ProductSearchResponse(2L, "Mobile", "Electronics"));
        products.add(new ProductSearchResponse(3L, "Shirt", "Clothing"));
    }

    public List<ProductSearchResponse> findAll() {
        return products;
    }

    public List<ProductSearchResponse> findByCategory(String category) {
        List<ProductSearchResponse> result = new ArrayList<>();

        for (ProductSearchResponse product : products) {
            if (product.category().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }

        return result;
    }
}
