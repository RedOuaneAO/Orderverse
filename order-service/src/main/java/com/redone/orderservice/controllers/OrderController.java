package com.redone.orderservice.controllers;

import com.redone.orderservice.domain.models.Order;
import com.redone.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order savedOrder = orderService.addOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/product/{productId}")
    public List<Order> getOrdersByProductId(@PathVariable("productId") Long productId) {
        return orderService.getOrdersByProductId(productId);
    }

}