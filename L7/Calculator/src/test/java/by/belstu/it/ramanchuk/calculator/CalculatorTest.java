package by.belstu.it.ramanchuk.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "1.0, 2.0, 3.0",
            "2.0, -3.0, -1.0",
            "-2.23, 33.2, 30.97",
            "0.0, -2.1, -2.1",
    })
    void add_WithTwoNumbers_ReturnsSum(double num1, double num2, double expectedResult) {
        double result = Calculator.add(num1, num2);
        assertEquals(expectedResult, result, 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 1.0, 2.0",
            "-1.0, 2.0, -3.0",
            "30.97, -2.23, 33.2",
            "-2.1, 0.0, -2.1",
    })
    void subtract_WithTwoNumbers_ReturnsDifference(double num1, double num2, double expectedResult) {
        double result = Calculator.subtract(num1, num2);
        assertEquals(expectedResult, result, 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 2.0, 2.0",
            "2.0, -3.0, -6.0",
            "-2.23, 33.2, -74.036",
            "0.0, -2.1, 0.0",
    })
    void multiply_WithTwoNumbers_ReturnsProduct(double num1, double num2, double expectedResult) {
        double result = Calculator.multiply(num1, num2);
        assertEquals(expectedResult, result, 1e-4);
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 2.0, 0.5",
            "2.0, -3.0, -0.66666666",
            "-45.5, -1.5, 30.33333333",
            "0.0, -2.1, 0.0",
    })
    void divide_WithNonZeroDenominator_ReturnsQuotient(double num1, double num2, double expectedResult) {
        try {
            double result = Calculator.divide(num1, num2);
            assertEquals(expectedResult, result, 1e-4);
        } catch (Calculator.CalculatorException e) {
            fail();
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 0.0",
    })
    void divide_WithZeroDenominator_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(Calculator.CalculatorException.class, () -> Calculator.divide(num1, num2));
    }
}