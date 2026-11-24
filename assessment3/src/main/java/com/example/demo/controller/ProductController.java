package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ProductSearchResponse;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductSearchResponse> searchProducts(
            @RequestParam(required = false) String category) {

        if (category != null && !category.isBlank()) {
            return productService.findByCategory(category);
        }

        return productService.findAll();
    }
}
