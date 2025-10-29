package com.skillbox.fibonacci;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;
    private final FibonacciService service = mock(FibonacciService.class);

    @Autowired
    private FibonacciController controller;

    @ParameterizedTest
    @CsvSource({"4,3", "16,987", "20,6765"})
    public void givenIndexGreaterThan0_whenGetNumberFromDb_thenReturnJSONString(Integer index, Integer number) throws Exception {
        FibonacciNumber fibonacciNumber = new FibonacciNumber(index, number);
        when(service.fibonacciNumber(index)).thenReturn(Optional.of(fibonacciNumber).get());
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci/%d".formatted(index)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        FibonacciNumber numberFromController = (FibonacciNumber) controller.getNumber(index).getBody();
        assertEquals("{\"index\":" + numberFromController.getIndex()
                        + ",\"value\":" + numberFromController.getValue() + "}",
                result.andReturn().getResponse().getContentAsString());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void givenIndexLessThanOne_whenGetNumberFromDb_thenReturnStatus400AndError(Integer index) throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci/%d".formatted(index)))
                .andExpect(status().is(400))
                .andExpect(content().string("Index should be greater or equal to 1"));
        String response = controller.getNumber(index).getBody().toString();
        String responseFromMockMvc = result.andReturn().getResponse().getContentAsString();
        assertEquals(response, responseFromMockMvc);
    }
}
