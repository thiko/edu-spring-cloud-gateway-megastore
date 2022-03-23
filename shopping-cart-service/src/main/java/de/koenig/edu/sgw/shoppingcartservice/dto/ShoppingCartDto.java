package de.koenig.edu.sgw.shoppingcartservice.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class ShoppingCartDto {

    UUID user;
    List<ProductDto> products;
    Double shippingCosts;
}
