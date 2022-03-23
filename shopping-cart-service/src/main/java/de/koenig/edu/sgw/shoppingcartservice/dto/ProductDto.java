package de.koenig.edu.sgw.shoppingcartservice.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ProductDto {

    String productName;
    Double productPrice;
}
