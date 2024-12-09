package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionParserTest {

    @Test
    public void testParenthesesEvaluation() {
        String expression = "(3 + 5) * 2";
        double result = RecursiveExpressionParser.evaluateExpression(expression);
        assertEquals("Expected result for '(3 + 5) * 2' is 16.0", 16.0, result, 0.0001);
    }

    @Test
    public void testSingleNumberEvaluation() {
        String expression = "5";
        double result = RecursiveExpressionParser.evaluateExpression(expression);
        assertEquals("Expected result for '5' is 5.0", 5.0, result, 0.0001);
    }

    @Test
    public void testDecimalEvaluation() {
        String expression = "3.5 + 2.5";
        double result = RecursiveExpressionParser.evaluateExpression(expression);
        assertEquals("Expected result for '3.5 + 2.5' is 6.0", 6.0, result, 0.0001);
    }

    @Test
    public void testDivisionEvaluation() {
        String expression = "6 / 2";
        double result = RecursiveExpressionParser.evaluateExpression(expression);
        assertEquals("Expected result for '6 / 2' is 3.0", 3.0, result, 0.0001);
    }

    @Test
    public void testMixedOperatorsEvaluation() {
        String expression = "10 + 2 * 5 - 3";
        double result = RecursiveExpressionParser.evaluateExpression(expression);
        assertEquals("Expected result for '10 + 2 * 5 - 3' is 17.0", 17.0, result, 0.0001);
    }
}
