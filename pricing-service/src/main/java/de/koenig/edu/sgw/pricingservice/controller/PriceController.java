package de.koenig.edu.sgw.pricingservice.controller;

import de.koenig.edu.sgw.pricingservice.dto.PriceDto;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @GetMapping
    public Flux<PriceDto> getAllPrices() {

        val staticPrices = List.of(
                PriceDto.builder().identifier(UUID.randomUUID()).productName("Haus am Strand").price(1200000.0).build(),
                PriceDto.builder().identifier(UUID.randomUUID()).productName("Tolles Velo").price(1000.0).build(),
                PriceDto.builder().identifier(UUID.randomUUID()).productName("Superman Comic").price(25.0).build());

        return Flux.fromIterable(staticPrices);
    }
}
