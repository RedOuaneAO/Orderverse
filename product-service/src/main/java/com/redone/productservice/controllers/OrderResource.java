package com.redone.productservice.controllers;

import com.redone.productservice.dto.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service" , url = "${application.config.orderUrl}")
public interface OrderResource {
    @GetMapping("/product/{productId}")
    List<OrderResponse> findAllOrdersByProductId(@PathVariable("productId") Long productId);
}
