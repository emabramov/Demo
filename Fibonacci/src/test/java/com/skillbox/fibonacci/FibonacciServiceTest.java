package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class FibonacciServiceTest {
    private final FibonacciRepository repositoryMock = Mockito.mock(FibonacciRepository.class);
    private final FibonacciCalculator calculatorMock = Mockito.mock(FibonacciCalculator.class);
    @InjectMocks
    private final FibonacciService service = new FibonacciService(repositoryMock, calculatorMock);

    @ParameterizedTest
    @DisplayName("Test return number by given index from DB")
    @CsvSource({"4,3", "16,987", "20,6765"})
    public void givenIndex_whenFindByIndex_thenReturnNumberFibonacci(Integer index, Integer number) {
        FibonacciNumber fibonacciNumberGiven = new FibonacciNumber(index, number);
        when(repositoryMock.findByIndex(index)).thenReturn(Optional.of(fibonacciNumberGiven));
        FibonacciNumber fibonacciNumber = service.fibonacciNumber(index);
        assertEquals(number, fibonacciNumber.getValue());
        verify(repositoryMock, times(1)).findByIndex(index);
        verify(repositoryMock, never()).save(fibonacciNumberGiven);
    }

    @ParameterizedTest
    @DisplayName("Test save fibonacci number to db and get it from db")
    @CsvSource({"4,3", "16,987", "20,6765"})
    public void givenIndex_whenNotFindByIndex_thenSaveNewFibonacciNumberToBdAndReturnIt(Integer index, Integer number) {
        FibonacciNumber fibonacciNumberGiven = new FibonacciNumber(index, number);
        when(repositoryMock.findByIndex(index)).thenReturn(Optional.empty());
        when(calculatorMock.getFibonacciNumber(index)).thenReturn(number);
        FibonacciNumber fibonacciNumber = service.fibonacciNumber(index);
        assertEquals(number, fibonacciNumber.getValue());
        verify(repositoryMock, times(1)).save(any(FibonacciNumber.class));
        verify(repositoryMock, times(1)).findByIndex(index);
        verify(calculatorMock, times(1)).getFibonacciNumber(index);
    }

    @ParameterizedTest
    @DisplayName("Test throw exception when index less than 1")
    @ValueSource(ints = {0, -1})
    public void givenIndexLessThanOne_whenFindByIndex_thenThrowException(Integer index) {
        IllegalArgumentException throwingException = assertThrows(IllegalArgumentException.class,
                () -> {
                    service.fibonacciNumber(index);
                });
        assertEquals("Index should be greater or equal to 1", throwingException.getMessage());
        verify(repositoryMock, never()).findByIndex(any(Integer.class));
        verify(calculatorMock, never()).getFibonacciNumber(any(Integer.class));
    }
}
