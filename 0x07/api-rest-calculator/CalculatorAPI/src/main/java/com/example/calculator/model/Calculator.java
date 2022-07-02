package com.example.calculator.model;

import java.time.LocalDate;
import java.time.Period;

public class Calculator {
    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null)
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null)
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
       if (number1 == null || number2 == null){
           throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
       }
       if (number2 == 0){
           throw new ArithmeticException("Divisão por zero não é permitido.");
       }
       return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if (factorial == null){
            throw new NullPointerException("Número é obrigatório.");
        }


        Integer fact = 1;
            for (int i=1; i<=factorial; i++){
                fact = fact * i;
            }
            return fact;
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        return Integer.valueOf(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer).toUpperCase();
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);

        return period.getDays();
    }
}
