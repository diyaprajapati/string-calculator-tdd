package com.diya.stringcalculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

    void shouldSupportNewLinesBetweenNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        assertThat(result).isEqualTo(6);
    }
}
