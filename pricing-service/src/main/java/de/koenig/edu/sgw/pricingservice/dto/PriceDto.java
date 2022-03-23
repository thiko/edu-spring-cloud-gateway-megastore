package de.koenig.edu.sgw.pricingservice.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PriceDto {

    UUID identifier;
    String productName;
    Double price;
}
