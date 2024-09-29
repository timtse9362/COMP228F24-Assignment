import javax.swing.*;
import java.util.Random;

public class Lotto {
    private int[] numbers; // Array to hold three random integer values
    private Random random;

    // Constructor that initializes the array with random integers from 1 to 9
    public Lotto() {
        random = new Random();
        numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(9) + 1; // Random number between 1 and 9
        }
    }

    // Function to return the array of numbers
    public int[] getNumbers() {
        return numbers;
    }

    // Function to calculate the sum of the numbers
    public int calculateSum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}