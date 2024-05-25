package com.springapp.coffeespringbackendapp.entities;

import com.springapp.coffeespringbackendapp.enums.CoffeeType;
import lombok.Data;

@Data
public class Coffee {
    private CoffeeType type;
    private int ageMonths;
    private double humidity;
    private double packagingCondition;
    private double impuritiesPercentage;
}
