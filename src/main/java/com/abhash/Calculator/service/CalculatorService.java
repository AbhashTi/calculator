package com.abhash.Calculator.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final Logger logger = LogManager.getLogger(CalculatorService.class);

    public int add(int a, int b) {
        logger.info("Performing Addition");
        return a + b;
    }

    public int sub(int a, int b) {
        logger.info("Performing Subtraction");
        return a - b;
    }

    public int mul(int a, int b) {
        logger.info("Performing Multiplication");
        return a * b;
    }

    public int div(int a, int b) {
        logger.info("Performing Division");
        return a / b;
    }
}