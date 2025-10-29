package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {

    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    @ParameterizedTest
    @DisplayName("Test save fibonacci number to DB")
    @CsvSource({"1,1", "5,5", "10,55"})
    public void givenFibonacciNumber_whenSaveNumberToDB_thenCheckSavedData(Integer index, Integer number) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber(index, number);
        entityManager.persist(fibonacciNumber);
        entityManager.flush();
        entityManager.clear();
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = %d".formatted(index),
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(fibonacciNumber.getValue(), actual.get(0).getValue());
    }

    @ParameterizedTest
    @DisplayName("Test get values from DB and count saved numbers")
    @CsvSource({"1,1", "5,5", "10,55"})
    public void givenFibonacciNumber_whenSaveGetNumberFromDB_thenCheckSavedDataAndCountSavedNumbers(Integer index, Integer number) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber(index, number);
        FibonacciNumber fibonacciNumberTwo = new FibonacciNumber(index, number);
        repository.save(fibonacciNumber);
        entityManager.flush();
        entityManager.clear();
        repository.save(fibonacciNumberTwo);
        entityManager.flush();
        entityManager.clear();
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = %d".formatted(index),
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        List<FibonacciNumber> allNumbers = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        List<FibonacciNumber> numberList = new ArrayList<>();
        numberList.add(repository.findByIndex(index).get());
        assertEquals(fibonacciNumber.getValue(), actual.get(0).getValue());
        assertEquals(1, allNumbers.size());
    }
}
