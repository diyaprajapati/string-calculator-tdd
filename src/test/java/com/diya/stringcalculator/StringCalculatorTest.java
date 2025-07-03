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
}
