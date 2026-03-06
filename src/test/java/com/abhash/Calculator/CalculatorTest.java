package com.abhash.Calculator;

import com.abhash.Calculator.service.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private CalculatorService calculator;

    @Before
    public void setup(){
        calculator = new CalculatorService();
    }

    @Test
    public void test_add(){
        Assert.assertEquals(3, calculator.add(1,2));
    }

    @Test
    public void test_sub(){
        Assert.assertEquals(1, calculator.sub(3,2));
    }

}
