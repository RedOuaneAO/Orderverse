package com.redone.productservice.services;

import com.redone.productservice.domain.models.Product;
import com.redone.productservice.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    ResponseEntity<Product> addProduct(Product product);

    ProductResponse getProductWithOrders(Long productId);
}
