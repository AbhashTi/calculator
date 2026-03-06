package com.abhash.Calculator.controller;

import com.abhash.Calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b) {
        return calculatorService.sub(a, b);
    }

    @GetMapping("/mul")
    public int mul(@RequestParam int a, @RequestParam int b) {
        return calculatorService.mul(a, b);
    }

    @GetMapping("/div")
    public int div(@RequestParam int a, @RequestParam int b) {
        return calculatorService.div(a, b);
    }
}
