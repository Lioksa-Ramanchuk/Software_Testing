package by.belstu.it.ramanchuk.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static by.belstu.it.ramanchuk.calculator.Calculator.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Stream<Arguments> provideInvalidNumbers() {
        return Stream.of(
                Arguments.of(Double.POSITIVE_INFINITY, 1.0),
                Arguments.of(1.0, Double.NEGATIVE_INFINITY),
                Arguments.of(Double.NaN, 1.0),
                Arguments.of(1.0, Double.NaN)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 2.0, 3.0",
            "2.0, -3.0, -1.0",
            "-2.23, 33.2, 30.97",
            "0.0, -2.1, -2.1",
    })
    void add_WithValidNumbers_ReturnsSum(double num1, double num2, double expectedResult) {
        try {
            double result = add(num1, num2);
            assertEquals(expectedResult, result, 1e-5);
        } catch (CalculatorException e) {
            fail();
        }
    }
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void add_WithInvalidNumbers_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(CalculatorException.class, () -> add(num1, num2));
    }
    @ParameterizedTest
    @CsvSource({
            ("" + Double.MAX_VALUE + "," + Double.MAX_VALUE),
            ("" + -Double.MAX_VALUE + "," + -Double.MAX_VALUE),
    })
    void add_WithInvalidResult_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(CalculatorException.class, () -> add(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 1.0, 2.0",
            "-1.0, 2.0, -3.0",
            "30.97, -2.23, 33.2",
            "-2.1, 0.0, -2.1",
    })
    void subtract_WithTwoNumbers_ReturnsDifference(double num1, double num2, double expectedResult) {
        try {
            double result = subtract(num1, num2);
            assertEquals(expectedResult, result, 1e-5);
        } catch (CalculatorException e) {
            fail();
        }
    }
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void subtract_WithInvalidNumbers_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(CalculatorException.class, () -> subtract(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 2.0, 2.0",
            "2.0, -3.0, -6.0",
            "-2.23, 33.2, -74.036",
            "0.0, -2.1, 0.0",
    })
    void multiply_WithTwoNumbers_ReturnsProduct(double num1, double num2, double expectedResult) {
        try {
            double result = multiply(num1, num2);
            assertEquals(expectedResult, result, 1e-4);
        } catch (CalculatorException e) {
            fail();
        }
    }
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void multiply_WithInvalidNumbers_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(CalculatorException.class, () -> multiply(num1, num2));
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
            double result = divide(num1, num2);
            assertEquals(expectedResult, result, 1e-4);
        } catch (CalculatorException e) {
            fail();
        }
    }
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void divide_WithInvalidNumbers_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(CalculatorException.class, () -> divide(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 0.0",
    })
    void divide_WithZeroDenominator_ThrowsCalculatorException(double num1, double num2) {
        assertThrows(CalculatorException.class, () -> divide(num1, num2));
    }
}