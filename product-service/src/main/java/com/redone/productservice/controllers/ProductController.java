package com.redone.productservice.controllers;

import com.redone.productservice.domain.models.Product;
import com.redone.productservice.dto.ProductResponse;
import com.redone.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/productWithOrders/{productId}")
    public ProductResponse getProductWithOrders(@PathVariable("productId") Long productId) {
        return productService.getProductWithOrders(productId);
    }

}
