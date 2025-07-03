package com.diya.stringcalculator;

public class StringCalculator {
    public int add(String numbers) {
        //for empty string
        if(numbers.isEmpty()) return 0;

        //for multiple numbers separated by comma
        String[] numbersArray = numbers.split("[,\n]");
        int sum = 0;
        for(String number : numbersArray) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
