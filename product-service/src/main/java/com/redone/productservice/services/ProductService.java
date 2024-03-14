package com.redone.productservice.services;

import com.redone.productservice.domain.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(Product product);
}
