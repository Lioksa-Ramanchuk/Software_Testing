package by.belstu.it.ramanchuk.calculator;

public class Calculator {
    public static class CalculatorException extends Exception {
        public CalculatorException(String message) {
            super(message);
        }
    }

    private static void validateParams(double num1, double num2) throws CalculatorException {
        if (!Double.isFinite(num1)) {
            throw new CalculatorException("Первый аргумент не является конечным числом");
        }
        if (!Double.isFinite(num2)) {
            throw new CalculatorException("Второй аргумент не является конечным числом");
        }
    }
    private static void validateResult(double result) throws CalculatorException {
        if (!Double.isFinite(result)) {
            throw new CalculatorException("Результат операции не является конечным числом");
        }
    }

    public static double add(double num1, double num2) throws CalculatorException {
        validateParams(num1, num2);
        double result = num1 + num2;
        validateResult(result);
        return result;
    }

    public static double subtract(double num1, double num2) throws CalculatorException {
        validateParams(num1, num2);
        double result = num1 - num2;
        validateResult(result);
        return result;
    }

    public static double multiply(double num1, double num2) throws CalculatorException {
        validateParams(num1, num2);
        double result = num1 * num2;
        validateResult(result);
        return result;
    }

    public static double divide(double num1, double num2) throws CalculatorException {
        validateParams(num1, num2);
        if (num2 == 0) {
            throw new CalculatorException("Деление на ноль является недопустимой операцией.");
        }
        double result = num1 / num2;
        validateResult(result);
        return result;
    }
}