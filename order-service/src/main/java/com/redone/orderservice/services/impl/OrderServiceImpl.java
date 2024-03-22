package com.redone.orderservice.services.impl;

import com.redone.orderservice.domain.models.Order;
import com.redone.orderservice.repositories.OrderRepository;
import com.redone.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByProductId(Long productId) {
        return orderRepository.findAllByProductId(productId.toString());
    }
}
