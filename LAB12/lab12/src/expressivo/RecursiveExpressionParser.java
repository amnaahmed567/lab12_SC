package expressivo;

import java.util.Scanner;

public class RecursiveExpressionParser {

    // Main method to evaluate mathematical expressions recursively
    public static double evaluateExpression(String expression) {
        // Clean up input by removing spaces
        String sanitizedExpression = expression.replaceAll("\\s", "");
        return processExpression(sanitizedExpression);
    }

    private static double processExpression(String expression) {
        // Base case: Check if the expression is a standalone number
        if (expression.matches("-?\\d+(\\.\\d+)?")) {
            return Double.parseDouble(expression);
        }

        // Handle parentheses: Evaluate the innermost parenthetical expression first
        if (expression.contains("(")) {
            int startIdx = expression.lastIndexOf('(');
            int endIdx = expression.indexOf(')', startIdx);

            if (startIdx != -1 && endIdx != -1) {
                String subExpression = expression.substring(startIdx + 1, endIdx);
                double result = processExpression(subExpression);

                // Replace the evaluated part with its result and recurse
                String updatedExpression = expression.substring(0, startIdx) + result + expression.substring(endIdx + 1);
                return processExpression(updatedExpression);
            }
        }

        // Handle addition and subtraction
        int addSubIdx = findLastOperator(expression, "+", "-");
        if (addSubIdx != -1) {
            char operator = expression.charAt(addSubIdx);
            double left = processExpression(expression.substring(0, addSubIdx));
            double right = processExpression(expression.substring(addSubIdx + 1));
            return operator == '+' ? left + right : left - right;
        }

        // Handle multiplication and division
        int mulDivIdx = findLastOperator(expression, "*", "/");
        if (mulDivIdx != -1) {
            char operator = expression.charAt(mulDivIdx);
            double left = processExpression(expression.substring(0, mulDivIdx));
            double right = processExpression(expression.substring(mulDivIdx + 1));

            if (operator == '/') {
                if (right == 0) {
                    throw new ArithmeticException("Division by zero is undefined.");
                }
                return left / right;
            } else {
                return left * right;
            }
        }

        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    private static int findLastOperator(String expression, String op1, String op2) {
        // Find the last occurrence of either operator in the expression
        int index1 = expression.lastIndexOf(op1);
        int index2 = expression.lastIndexOf(op2);
        return Math.max(index1, index2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a mathematical expression to evaluate:");
        String userInput = scanner.nextLine();

        try {
            // Process the input and display the result
            double result = evaluateExpression(userInput);
            System.out.println("Computed Result: " + result);
        } catch (Exception ex) {
            // Display error messages for invalid input
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
