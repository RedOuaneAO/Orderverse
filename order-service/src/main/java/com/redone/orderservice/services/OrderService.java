package com.redone.orderservice.services;

import com.redone.orderservice.domain.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();

    Order addOrder(Order order);

    List<Order> getOrdersByProductId(Long productId);
}
