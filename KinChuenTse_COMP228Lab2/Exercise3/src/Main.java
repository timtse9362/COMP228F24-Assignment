//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Function to find the maximum of two integers
    public static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }

    // Function to find the maximum of three integers
    public static int findMax(int a, int b, int c) {
        return findMax(findMax(a, b), c);
    }

    // Function to find the maximum of four integers
    public static int findMax(int a, int b, int c, int d) {
        return findMax(findMax(a, b, c), d);
    }

    // Function to find the maximum value in an array of doubles
    public static double findMax(double[] numbers) {
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Main function to call the overloaded methods and display results
    public static void main(String[] args) {
        // Find maximum of two integers
        int maxOfTwo = findMax(10, 20);
        System.out.println("Maximum of 10 and 20: " + maxOfTwo);

        // Find maximum of three integers
        int maxOfThree = findMax(5, 15, 10);
        System.out.println("Maximum of 5, 15, and 10: " + maxOfThree);

        // Find maximum of four integers
        int maxOfFour = findMax(7, 14, 3, 9);
        System.out.println("Maximum of 7, 14, 3, and 9: " + maxOfFour);

        // Find maximum in an array of doubles
        double[] values = {2.5, 3.7, 1.8, 4.2, 3.9};
        double maxInArray = findMax(values);
        System.out.println("Maximum value in the array: " + maxInArray);
    }
}