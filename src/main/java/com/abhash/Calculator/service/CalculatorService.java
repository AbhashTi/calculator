package com.abhash.Calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        long result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }

        return Math.log(x);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}