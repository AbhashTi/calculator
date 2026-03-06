package com.abhash.Calculator.controller;

import com.abhash.Calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/sqrt")
    public double squareRoot(@RequestParam double x){
        return calculatorService.squareRoot(x);
    }

    @GetMapping("/factorial")
    public long factorial(@RequestParam int x){
        return calculatorService.factorial(x);
    }

    @GetMapping("/ln")
    public double naturalLog(@RequestParam double x){
        return calculatorService.naturalLog(x);
    }

    @GetMapping("/power")
    public double power(@RequestParam double base, @RequestParam double exp){
        return calculatorService.power(base, exp);
    }
}