package de.koenig.edu.sgw.megastoregateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// See https://cloud.spring.io/spring-cloud-gateway/reference/html/
@Configuration
public class MegastoreGatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("route-to-pricing-service", r -> r.path("/super-prices")
                        .filters(f -> f.rewritePath("super-prices", "/prices"))
                        .uri("http://localhost:9090"))
                .route("route-to-shopping-cart", r -> r.method("GET").and().header("x-customer-class", "rich").and().path("/shoppingcard")
                        .uri("http://localhost:9080"))
                        .build();
    }
}
