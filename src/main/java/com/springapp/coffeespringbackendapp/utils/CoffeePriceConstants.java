package com.springapp.coffeespringbackendapp.utils;

public final class CoffeePriceConstants {

    public static final class BasePrice {
        public static final double GRAIN = 700.0;
        public static final double GROUND = 400.0;
        public static final double INSTANT = 200.0;
    }

    public static final class Discount {
        public static final double AGE_PERCENTAGE = 0.05;
    }

    public static final class HumidityDiscount {
        public static final double LEVEL_1_THRESHOLD = 33.0;
        public static final double LEVEL_2_THRESHOLD = 66.0;
        public static final double LEVEL_1 = 0.95;
        public static final double LEVEL_2 = 0.85;
        public static final double LEVEL_3 = 0.75;
    }

    public static final class PackagingDiscount {
        public static final double LEVEL_1_THRESHOLD = 33.0;
        public static final double LEVEL_2_THRESHOLD = 66.0;
        public static final double LEVEL_1 = 0.95;
        public static final double LEVEL_2 = 0.90;
        public static final double LEVEL_3 = 0.80;
    }

    public static final class ImpuritiesDiscount {
        public static final double LEVEL_1_THRESHOLD = 33.0;
        public static final double LEVEL_2_THRESHOLD = 66.0;
        public static final double LEVEL_1 = 0.90;
        public static final double LEVEL_2 = 0.80;
        public static final double LEVEL_3 = 0.70;
    }

    public static final class MinPrice {
        public static final double GRAIN = 200.0;
        public static final double GROUND = 500.0;
        public static final double INSTANT = 300.0;
    }

    private CoffeePriceConstants() {
    }
}
