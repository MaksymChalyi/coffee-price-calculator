package com.springapp.coffeespringbackendapp.exceptions.handlers;

import com.springapp.coffeespringbackendapp.exceptions.CoffeePriceCalculationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CoffeeControllerAdvice {
    @ExceptionHandler(CoffeePriceCalculationException.class)
    public ResponseEntity<String> handleCoffeePriceCalculationException(CoffeePriceCalculationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}