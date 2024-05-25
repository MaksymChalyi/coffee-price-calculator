package com.springapp.coffeespringbackendapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CoffeePriceCalculationException extends RuntimeException {
    public CoffeePriceCalculationException(String message) {
        super(message);
    }
}
