package com.abhash.Calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    // Square Root
    public double squareRoot(double x) {

        if (x < 0) {
            throw new IllegalArgumentException("Square root of negative number is not defined");
        }

        return Math.sqrt(x);
    }

    // Factorial
    public long factorial(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Factorial of negative number is not defined");
        }

        if (n > 20) {
            throw new IllegalArgumentException("Number too large (overflow risk)");
        }

        long result = 1;

        for(int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // Natural Log
    public double naturalLog(double x) {

        if (x <= 0) {
            throw new IllegalArgumentException("Natural log undefined for zero or negative numbers");
        }

        return Math.log(x);
    }

    // Power Function
    public double power(double base, double exponent) {

        if(base == 0 && exponent == 0) {
            throw new IllegalArgumentException("0^0 is undefined");
        }

        return Math.pow(base, exponent);
    }
}