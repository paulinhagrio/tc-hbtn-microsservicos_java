package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value="/calculator")
public class CalculatorController {

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "n1") Double n1, @RequestParam(name = "n2") Double n2) {

        return new Calculator().sum(n1, n2).toString();
    }

        @GetMapping("/subNumbers")
        public String subNumbers(@RequestParam(name = "n1") Double n1, @RequestParam(name = "n2") Double n2) {

            return new Calculator().sub(n1, n2).toString();
        }

        @GetMapping("/divideNumbers")
        public String divideNumbers(@RequestParam(name = "n1") Double n1, @RequestParam(name = "n2") Double n2) {
            return new Calculator().divide(n1, n2).toString();
        }

        @GetMapping("/factorial")
        public String factorial(@RequestParam(name = "factorial") Integer factorial) {
            return new Calculator().factorial(factorial).toString();

        }

        @GetMapping("/calculeDayBetweenDate")
        public String calculeDayBetweenDate(
               @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
               @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {

            return String.valueOf(new Calculator().calculeDayBetweenDate(localDate1, localDate2));
        }

        @GetMapping("/integerToBinary")
        public String integerToBinary(@RequestParam(name = "n1") Integer n1) {
            return new Calculator().integerToBinary(n1).toString();
        }

        @GetMapping("/integerToHexadecimal")
        public String integerToHexadecimal(@RequestParam(name = "n1") Integer n1) {
            return new Calculator().integerToHexadecimal(n1).toString();
        }
    }

