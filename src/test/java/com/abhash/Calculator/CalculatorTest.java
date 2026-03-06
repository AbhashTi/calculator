package com.abhash.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.abhash.Calculator.service.CalculatorService;

public class CalculatorTest {

    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(3, calculator.add(1,2));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(1, calculator.sub(3,2));
    }
}
