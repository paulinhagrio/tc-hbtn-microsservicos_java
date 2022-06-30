package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

   @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
       Double n1 = 400.0;
       Double n2 = 600.0;
       String url = "/calculator/addNumbers?number1=" + n1 + "&number2" + n2;
       RequestBuilder request = get(url);
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals(1000.0, result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception{
       Double n1 = 1000.0;
       Double n2 = 600.0;
       String url = "/calculator/subNumbers?number1=" + n1 + "&number2" + n2;
       RequestBuilder request = get(url);
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals(400.0, result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception{
        Double n1 = 1000.0;
        Double n2 = 2.0;
        String url = "/calculator/divideNumbers?number1=" + n1 + "&number2" + n2;
        RequestBuilder request = get(url);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(500.0, result.getResponse().getContentAsString());

    }

    @Test
    void factorial() throws Exception{
       Integer factorial = 3;
       String url = "/calculator/factorial?factorial=" + factorial;
       RequestBuilder request = get(url);
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals(6, result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception{
        String localDate1 = "2020-03-15";
        String localDate2 = "2020-03-30";
        // Total de dias = 15
        String url = "/calculator/calculeDayBetweenDate?localDate1=" + localDate1 + "&localDate2" + localDate2;
        RequestBuilder request = get(url);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(15, result.getResponse().getContentAsString());


    }

    @Test
    void integerToBinary() throws Exception{
       Integer n1 = 5;
       String url = "/calculator/integerToBinary?number1" + n1;
       RequestBuilder request = get(url);
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals(101, result.getResponse().getContentAsString());

    }

    @Test
    void integerToHexadecimal() throws Exception{
       Integer n1 = 5;
       String url = "/calculator/integerToHexadecimal?number1" + n1;
       RequestBuilder request = get(url);
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("AA", result.getResponse().getContentAsString());

    }

    // TODO - Implementar os demais métodos:  , ,
    //        ,  e
}




