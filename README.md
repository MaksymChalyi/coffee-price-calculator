# Coffee Price Calculator

This Java service calculates the price of coffee based on different parameters such as coffee type, age, humidity, packaging condition, and impurities percentage.

## Description

The Coffee Price Calculator service takes input in the form of a CoffeeRequestDTO object containing the coffee type, age in months, humidity, packaging condition, and impurities percentage. It then applies various discounts based on these parameters to determine the final price of the coffee.

## Features

- Supports three types of coffee: grain, ground, and instant.
- Discounts applied based on the age of the coffee, humidity level, packaging condition, and impurities percentage.
- Price limits enforced based on the type of coffee.
- Error handling for invalid input parameters.

## Usage

To use the Coffee Price Calculator service, send a POST request with a JSON payload containing the coffee parameters to the appropriate endpoint. The service will respond with the calculated price of the coffee.

Example JSON Request:
```
{
"type": "GROUND",
"ageMonths": 12,
"humidity": 40,
"packagingCondition": 70,
"impuritiesPercentage": 25
}
```

Example Response:
```
{
"price": 243.0
}
```
---
Example JSON Request:
```
{
    "type": "GRAIN",
    "ageMonths": 12,
    "humidity": 20,
    "packagingCondition": 50,
    "impuritiesPercentage": 10
}
```

Example Response:
```
{
    "price": 535.0
}
```
---
Example JSON Request:
```
{
    "type": "GROUND",
    "ageMonths": 6,
    "humidity": 15,
    "packagingCondition": 70,
    "impuritiesPercentage": 30
}

```

Example Response:
```
{
"price": 273.0
}
```
---
Example JSON Request:
```
{
    "type": "INSTANT",
    "ageMonths": 8,
    "humidity": 60,
    "packagingCondition": 30,
    "impuritiesPercentage": 5
}
```

Example Response:
```
{
    "price": 145.0
}
```

## License

This project is licensed under the MIT License.
