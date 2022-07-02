package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        assertEquals(1000.0, calculator.sum(400.0, 600.0));
    }

    @Test
    public void numbersNullSumTest() {

    Calculator calculadora = new Calculator();
    String msg = "Número 1 e número 2 são obrigatórios.";

    String mensagem = assertThrows(NullPointerException.class, () -> {
                calculadora.sum(null, null);
            }
    ).getMessage();
    assertEquals(msg, mensagem);

    }

    @Test
    void subTest() {
        assertEquals(400.0, calculator.sub(1000.0, 600.0));
    }

    @Test
    void divideTest() {
        assertEquals(500.0, calculator.divide(1000.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        try{
            calculator.divide(1000.0, 0.0);
            fail("Missing Exception");
        }catch(Throwable ex){
            assertEquals(ArithmeticException.class, ex.getClass());
            assertEquals("Divisão por zero não é permitido.", ex.getMessage());
        }
    }

    @Test
    void factorialTest() {
        assertEquals(6, calculator.factorial(3));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1, calculator.integerToBinary(1));
        assertEquals(101, calculator.integerToBinary(5));
        assertEquals(10100, calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        // Integer = 1 -> Hexadecimal = "1"
        // Integer = 5 -> Hexadecimal = "37"
        // Integer = 170 -> Binary = "AA"
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertNotEquals("25", calculator.integerToHexadecimal(5));
        assertEquals("AA", calculator.integerToHexadecimal(170));
    }



    @Test
    void calculeDayBetweenDateTest() {
        LocalDate Date1 = LocalDate.of(2020, 3, 15);
        LocalDate Date2 = LocalDate.of(2020, 3, 29);
        // Total de dias = 14

        assertEquals(14, calculator.calculeDayBetweenDate(Date1, Date2));
    }
}
