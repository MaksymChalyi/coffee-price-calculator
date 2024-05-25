package com.springapp.coffeespringbackendapp.services;

import com.springapp.coffeespringbackendapp.dtos.request.CoffeeRequestDTO;
import com.springapp.coffeespringbackendapp.enums.CoffeeType;
import com.springapp.coffeespringbackendapp.exceptions.CoffeePriceCalculationException;
import com.springapp.coffeespringbackendapp.utils.CoffeePriceConstants;
import org.springframework.stereotype.Service;

@Service
public class CoffeePriceCalculatorService {

    public double calculatePrice(CoffeeRequestDTO request) {
        double basePrice = calculateBasePrice(request.getType());
        double ageDiscount = calculateAgeDiscount(request.getAgeMonths());
        double humidityDiscount = calculateHumidityDiscount(request.getHumidity());
        double packagingDiscount = calculatePackagingDiscount(request.getPackagingCondition());
        double impuritiesDiscount = calculateImpuritiesDiscount(request.getImpuritiesPercentage());

        double finalPrice = basePrice * ageDiscount * humidityDiscount * packagingDiscount * impuritiesDiscount;
        return Math.round(applyPriceLimits(finalPrice, request.getType()));
    }

    private double calculateBasePrice(CoffeeType type) {
        switch (type) {
            case GRAIN:
                return CoffeePriceConstants.BasePrice.GRAIN;
            case GROUND:
                return CoffeePriceConstants.BasePrice.GROUND;
            case INSTANT:
                return CoffeePriceConstants.BasePrice.INSTANT;
            default:
                throw new CoffeePriceCalculationException("Invalid coffee type");
        }
    }

    double calculateAgeDiscount(int ageMonths) {
        return 1.0 - (ageMonths * CoffeePriceConstants.Discount.AGE_PERCENTAGE / 100);
    }

    private double calculateHumidityDiscount(double humidity) {
        if (humidity <= CoffeePriceConstants.HumidityDiscount.LEVEL_1_THRESHOLD) {
            return CoffeePriceConstants.HumidityDiscount.LEVEL_1;
        } else if (humidity <= CoffeePriceConstants.HumidityDiscount.LEVEL_2_THRESHOLD) {
            return CoffeePriceConstants.HumidityDiscount.LEVEL_2;
        } else {
            return CoffeePriceConstants.HumidityDiscount.LEVEL_3;
        }
    }

    private double calculatePackagingDiscount(double packagingCondition) {
        if (packagingCondition <= CoffeePriceConstants.PackagingDiscount.LEVEL_1_THRESHOLD) {
            return CoffeePriceConstants.PackagingDiscount.LEVEL_1;
        } else if (packagingCondition <= CoffeePriceConstants.PackagingDiscount.LEVEL_2_THRESHOLD) {
            return CoffeePriceConstants.PackagingDiscount.LEVEL_2;
        } else {
            return CoffeePriceConstants.PackagingDiscount.LEVEL_3;
        }
    }

    private double calculateImpuritiesDiscount(double impuritiesPercentage) {
        if (impuritiesPercentage <= CoffeePriceConstants.ImpuritiesDiscount.LEVEL_1_THRESHOLD) {
            return CoffeePriceConstants.ImpuritiesDiscount.LEVEL_1;
        } else if (impuritiesPercentage <= CoffeePriceConstants.ImpuritiesDiscount.LEVEL_2_THRESHOLD) {
            return CoffeePriceConstants.ImpuritiesDiscount.LEVEL_2;
        } else {
            return CoffeePriceConstants.ImpuritiesDiscount.LEVEL_3;
        }
    }

    private double applyPriceLimits(double price, CoffeeType type) {
        return switch (type) {
            case GRAIN -> Math.max(price, CoffeePriceConstants.MinPrice.GRAIN);
            case GROUND -> Math.min(price, CoffeePriceConstants.MinPrice.GROUND);
            case INSTANT -> Math.min(price, CoffeePriceConstants.MinPrice.INSTANT);
        };
    }
}
