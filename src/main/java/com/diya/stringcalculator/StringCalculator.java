package com.diya.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        //for empty string
        if(numbers.isEmpty()) return 0;

        //for custom delimiter
        List<String> delimiters = new ArrayList<>(List.of(",", "\n"));

        if(numbers.startsWith("//")) {
            int end = numbers.indexOf('\n');

            //exception for malformed custom delimiters
            if(end == -1) {
                throw new IllegalArgumentException("Invalid input: missing newline after custom delimiter declaration");
            }

            String delimiterPart = numbers.substring(2,end);

            if (!delimiterPart.matches("(\\[.+?])+")) {
                throw new IllegalArgumentException("Invalid input: delimiter should be enclosed in brackets like //[***]");
            }

            Matcher m = Pattern.compile("\\[(.+?)\\]").matcher(delimiterPart);
            while(m.find()) {
                delimiters.add(Pattern.quote(m.group(1)));
            }
            numbers = numbers.substring(end+1);
        }

        String regex = String.join("|", delimiters);

        //for multiple numbers separated by comma and new line
        String[] numbersArray = numbers.split(regex, -1);
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

        //throws error and list of negative numbers
        if(!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(",", negatives));
        }

        return sum;
    }
}
