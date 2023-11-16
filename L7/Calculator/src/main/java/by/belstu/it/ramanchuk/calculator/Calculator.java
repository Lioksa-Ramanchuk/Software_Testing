package by.belstu.it.ramanchuk.calculator;

public class Calculator {
    public static class CalculatorException extends Exception {
        public CalculatorException(String message) {
            super(message);
        }
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) throws CalculatorException {
        if (num2 == 0) {
            throw new CalculatorException("Деление на ноль является недопустимой операцией.");
        }
        return num1 / num2;
    }
}