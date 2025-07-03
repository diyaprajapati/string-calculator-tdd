package com.diya.stringcalculator;

public class StringCalculator {
    public int add(String numbers) {
        //for empty string
        if(numbers.isEmpty()) return 0;

        //for two numbers separated by comma
        if(numbers.contains(",")) {
            String[] numbersArray = numbers.split(",");
            return Integer.parseInt(numbersArray[0]) + Integer.parseInt(numbersArray[1]);
        }

        //for single numbers
        return Integer.parseInt(numbers);
    }
}
