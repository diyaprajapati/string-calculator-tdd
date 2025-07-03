package com.diya.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        //for empty string
        if(numbers.isEmpty()) return 0;

        //for multiple numbers separated by comma and new line
        String[] numbersArray = numbers.split("[,\n]", -1);
        List<String> negatives = new ArrayList<>(); //to handle negative numbers
        int sum = 0;

        for(String number : numbersArray) {
            int num = Integer.parseInt(number);

            //if string ends with comma
            if(number.isBlank()) {
                throw new NumberFormatException("Invalid input: empty number after delimiter");
            }
            //if there is negative number in string
            if(num < 0) {
                negatives.add(number);
            }
            sum += num;
        }

        if(!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(",", negatives));
        }

        return sum;
    }
}
