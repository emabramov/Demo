package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FibonacciCalculatorTest {

    private final FibonacciCalculator calculator = new FibonacciCalculator();

    @ParameterizedTest
    @CsvSource({"3,2", "10,55", "40,102334155"})
    @DisplayName("Test get fibonacci number")
    public void testGetFibonacciNumber(Integer index, Integer number) {
        Integer fibonacciNumber = calculator.getFibonacciNumber(index);
        assertEquals(number, fibonacciNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    @DisplayName("Test get fibonacci number less than 1")
    public void givenIndexLessOne_whenGetFibonacciNumber_thenThrowException(Integer index) {
        IllegalArgumentException throwingException = assertThrows(IllegalArgumentException.class,
                () -> {
                    calculator.getFibonacciNumber(index);
                });
        assertEquals("Index should be greater or equal to 1", throwingException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,1"})
    @DisplayName("Test get fibonacci number 1 when index 1 or 2")
    public void givenOneOrTwo_whenGetFibonacciNumber_thenReturnOne(Integer index, Integer number) {
        Integer fibonacciNumber = calculator.getFibonacciNumber(index);
        assertEquals(number, fibonacciNumber);
    }
}
