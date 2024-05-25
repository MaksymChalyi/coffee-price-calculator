package com.springapp.coffeespringbackendapp.dtos.request;

import com.springapp.coffeespringbackendapp.enums.CoffeeType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoffeeRequestDTO {
    private CoffeeType type;
    private int ageMonths;
    private double humidity;
    private double packagingCondition;
    private double impuritiesPercentage;
}