package com.redone.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", predicateSpec -> predicateSpec.path("/api/orders/**")
                        .uri("lb://order-service")
                )
                .route("product-service",
                        predicateSpec -> predicateSpec.path("/api/products/**")
                                .uri("lb://product-service"))
                .build();
    }

}

