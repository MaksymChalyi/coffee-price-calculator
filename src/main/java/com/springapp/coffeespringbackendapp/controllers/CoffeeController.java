package com.springapp.coffeespringbackendapp.controllers;

import com.springapp.coffeespringbackendapp.dtos.request.CoffeeRequestDTO;
import com.springapp.coffeespringbackendapp.dtos.response.CoffeeResponseDTO;
import com.springapp.coffeespringbackendapp.services.CoffeePriceCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeePriceCalculatorService coffeePriceCalculatorService;

    @PostMapping("/price")
    public ResponseEntity<CoffeeResponseDTO> calculatePrice(@RequestBody CoffeeRequestDTO request) {
        double price = coffeePriceCalculatorService.calculatePrice(request);
        CoffeeResponseDTO responseDTO = new CoffeeResponseDTO();
        responseDTO.setPrice(price);
        return ResponseEntity.ok(responseDTO);
    }
}