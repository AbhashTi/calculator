package com.abhash.Calculator;

import com.abhash.Calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    public void testSquareRoot() {
        Assertions.assertEquals(5.0, calculator.squareRoot(25));
    }

    @Test
    public void testFactorial() {
        Assertions.assertEquals(120, calculator.factorial(5));
    }

    @Test
    public void testNaturalLog() {
        Assertions.assertEquals(Math.log(10), calculator.naturalLog(10));
    }

    @Test
    public void testPower() {
        Assertions.assertEquals(8.0, calculator.power(2,3));
    }
}