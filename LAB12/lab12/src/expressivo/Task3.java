package expressivo;

import java.util.Scanner;

public class Task3 {

    /**
     * Recursive function to calculate the sum of digits of a given number.
     * @param number the number whose digits are to be summed
     * @return the sum of the digits
     */
    public static int sumOfDigits(int number) {
        // Handle negative numbers by converting to positive
        if (number < 0) number = Math.abs(number);

        // Base case: when the number is reduced to 0
        if (number == 0) return 0;

        // Recursive case: add the last digit to the sum of the rest
        return (number % 10) + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();  // Read user input

            // Display the result
            int result = sumOfDigits(number);
            System.out.println("Sum of digits: " + result);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
