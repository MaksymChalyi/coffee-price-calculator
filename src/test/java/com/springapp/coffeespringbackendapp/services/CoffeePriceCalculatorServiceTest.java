package com.springapp.coffeespringbackendapp.services;

import com.springapp.coffeespringbackendapp.dtos.request.CoffeeRequestDTO;
import com.springapp.coffeespringbackendapp.enums.CoffeeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeePriceCalculatorServiceTest {

    @Test
    void testCalculatePrice_GrainCoffeeWithinLimits() {
        CoffeeRequestDTO request = new CoffeeRequestDTO(CoffeeType.GRAIN, 12, 20, 50, 10);
        CoffeePriceCalculatorService service = new CoffeePriceCalculatorService();
        double expectedPrice = 535.0;
        double actualPrice = service.calculatePrice(request);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testCalculatePrice_GroundCoffeeWithinLimits() {
        CoffeeRequestDTO request = new CoffeeRequestDTO(CoffeeType.GROUND, 18, 40, 80, 25);
        CoffeePriceCalculatorService service = new CoffeePriceCalculatorService();
        double expectedPrice = 243.0;
        double actualPrice = service.calculatePrice(request);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testCalculatePrice_InstantCoffeeWithinLimits() {
        CoffeeRequestDTO request = new CoffeeRequestDTO(CoffeeType.INSTANT, 8, 60, 30, 5);
        CoffeePriceCalculatorService service = new CoffeePriceCalculatorService();
        double expectedPrice = 145.0;
        double actualPrice = service.calculatePrice(request);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testCalculatePrice_AgeDiscount() {
        CoffeePriceCalculatorService service = new CoffeePriceCalculatorService();
        int ageMonths = 12;
        double expectedDiscount = 0.994;
        double actualDiscount = service.calculateAgeDiscount(ageMonths);
        assertEquals(expectedDiscount, actualDiscount);
    }
}
