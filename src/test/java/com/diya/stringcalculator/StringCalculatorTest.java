package com.diya.stringcalculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void shouldReturnZeroForEmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturnSameNumberWhenOnlyOneNumberGiven() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void shouldReturnSumWhenTwoNumbersGiven() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("5,2");
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldReturnSumForMultipleNumbersGiven() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3,4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void shouldSupportNewLinesBetweenNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldSupportCustomDelimiterOfAnyLength() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[***]\n1***2***3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldSupportMultipleCustomDelimiters() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[*][%]\n1*2%3");
        assertThat(result).isEqualTo(6);
    }

    //handle an exceptions
    @Test
    void shouldThrowErrorIfTrailingDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(NumberFormatException.class, () -> {calculator.add("1,2,");});
    }

    @Test
    void shouldThrowExceptionForNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {calculator.add("1,-2\n-3");});
        assertThat(exception.getMessage()).isEqualTo("Negative numbers not allowed: -2,-3");
    }

    @Test
    void shouldThrowErrorForMalformedCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("//***\n1***2");
        });
        assertThat(exception.getMessage()).isEqualTo("Invalid input: delimiter should be enclosed in brackets like //[***]");
    }

}
