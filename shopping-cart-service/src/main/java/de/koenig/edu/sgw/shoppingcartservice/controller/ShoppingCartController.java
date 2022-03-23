package de.koenig.edu.sgw.shoppingcartservice.controller;

import de.koenig.edu.sgw.shoppingcartservice.dto.ProductDto;
import de.koenig.edu.sgw.shoppingcartservice.dto.ShoppingCartDto;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shoppingcard")
public class ShoppingCartController {

    @GetMapping
    public Mono<ShoppingCartDto> getShoppingCart() {
        val mockedProducts = List.of(
                ProductDto.builder().productName("Shampoo").productPrice(3.50).build(),
                ProductDto.builder().productName("Cola").productPrice(2.10).build(),
                ProductDto.builder().productName("Chips").productPrice(1.75).build());

        return Mono.just(ShoppingCartDto.builder()
                .products(mockedProducts)
                .shippingCosts(10.56)
                .user(UUID.randomUUID()).build());
    }
}
