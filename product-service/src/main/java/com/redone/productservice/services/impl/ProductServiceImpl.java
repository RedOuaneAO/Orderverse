package com.redone.productservice.services.impl;

import com.redone.productservice.controllers.OrderResource;
import com.redone.productservice.domain.models.Product;
import com.redone.productservice.dto.ProductResponse;
import com.redone.productservice.repositories.ProductRepository;
import com.redone.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private  final OrderResource orderResource;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> addProduct(Product product) {
        var productExist= productRepository.findByName(product.getName());
        if(productExist !=null){
            return  ResponseEntity.badRequest().body(Product.builder().name("product already exist ").build());
        }
        Product product1= productRepository.save(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @Override
    public ProductResponse getProductWithOrders(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("there is no product with this id"));
        var orders = orderResource.findAllOrdersByProductId(productId);
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .quantityAvailable(product.getQuantityAvailable())
                .orderList(orders)
        .build();
    }
}
