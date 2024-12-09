package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void testSumOfDigitsWithPositiveNumber() {
        int number = 12345;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of 12345 should be 15", 15, result);
    }

    @Test
    public void testSumOfDigitsWithNegativeNumber() {
        int number = -12345;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of -12345 should be 15", 15, result);
    }

    @Test
    public void testSumOfDigitsWithSingleDigit() {
        int number = 7;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of 7 should be 7", 7, result);
    }

    @Test
    public void testSumOfDigitsWithZero() {
        int number = 0;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of 0 should be 0", 0, result);
    }

    @Test
    public void testSumOfDigitsWithLargeNumber() {
        int number = 987654321;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of 987654321 should be 45", 45, result);
    }

    @Test
    public void testSumOfDigitsWithEdgeCaseMinValue() {
        int number = Integer.MIN_VALUE;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of Integer.MIN_VALUE should be 47", 47, result);
    }

    @Test
    public void testSumOfDigitsWithEdgeCaseMaxValue() {
        int number = Integer.MAX_VALUE;
        int result = Task3.sumOfDigits(number);
        assertEquals("The sum of digits of Integer.MAX_VALUE should be 46", 46, result);
    }
}
