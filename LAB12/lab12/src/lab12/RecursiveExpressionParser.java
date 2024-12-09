package lab12;

import java.util.Scanner;

public class RecursiveExpressionParser {

    // Recursive evaluation of a mathematical expression
    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s", ""); // Remove spaces
        return parseExpression(expression);
    }

    private static double parseExpression(String expression) {
        // Base case: If the expression is just a number (could be negative or floating point)
        if (expression.matches("-?\\d+(\\.\\d+)?")) {
            return Double.parseDouble(expression);
        }

        // Handle parentheses: Find the most inner pair and evaluate it
        if (expression.contains("(")) {
            int openIndex = expression.lastIndexOf('(');
            int closeIndex = expression.indexOf(')', openIndex);
            
            if (openIndex != -1 && closeIndex != -1) {
                String insideParentheses = expression.substring(openIndex + 1, closeIndex);
                double resultInsideParentheses = parseExpression(insideParentheses);
                // Replace the parentheses with their evaluated result
                expression = expression.substring(0, openIndex) + resultInsideParentheses + expression.substring(closeIndex + 1);
                return parseExpression(expression);  // Recurse after replacing
            }
        }

        // Handle addition and subtraction (left to right)
        if (expression.contains("+") || expression.contains("-")) {
            int index = findOperatorIndex(expression, "+", "-");
            if (index != -1) {
                char operator = expression.charAt(index);
                if (operator == '+') {
                    return parseExpression(expression.substring(0, index)) + parseExpression(expression.substring(index + 1));
                } else if (operator == '-') {
                    return parseExpression(expression.substring(0, index)) - parseExpression(expression.substring(index + 1));
                }
            }
        }

        // Handle multiplication and division (left to right)
        if (expression.contains("*") || expression.contains("/")) {
            int index = findOperatorIndex(expression, "*", "/");
            if (index != -1) {
                char operator = expression.charAt(index);
                if (operator == '*') {
                    return parseExpression(expression.substring(0, index)) * parseExpression(expression.substring(index + 1));
                } else if (operator == '/') {
                    double denominator = parseExpression(expression.substring(index + 1));
                    if (denominator == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    return parseExpression(expression.substring(0, index)) / denominator;
                }
            }
        }

        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    private static int findOperatorIndex(String expression, String operator1, String operator2) {
        // Handle cases where negative signs are involved
        int index1 = expression.lastIndexOf(operator1);
        int index2 = expression.lastIndexOf(operator2);
        return Math.max(index1, index2); // Return the last operator found (for left-to-right evaluation)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression to evaluate:");

        // Take user input for the expression
        String expression = scanner.nextLine();

        try {
            // Evaluate the expression
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            // Handle errors (e.g., invalid expression)
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
