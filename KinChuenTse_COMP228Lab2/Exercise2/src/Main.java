import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lotto lottoGame = new Lotto();
        String input = JOptionPane.showInputDialog("Choose a number between 3 and 27:");

        // Check if the user clicked "Cancel" button
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Game canceled.");
            return;
        }

        int userChoice;
        try {
            userChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please restart the game and choose a number between 3 and 27.");
            return;
        }

        if (userChoice < 3 || userChoice > 27) {
            JOptionPane.showMessageDialog(null, "Invalid choice! Please restart the game and choose a number between 3 and 27.");
            return;
        }

        int attempts = 0;
        boolean hasWon = false;

        // Run the loop 5 times to generate lotto number 5 times
        while (attempts < 5) {
            lottoGame = new Lotto(); // Create a new Lotto object for each attempt
            int sum = lottoGame.calculateSum();
            attempts++;

            String message = "Attempt " + attempts + ": Lotto numbers are " +
                    lottoGame.getNumbers()[0] + ", " +
                    lottoGame.getNumbers()[1] + ", " +
                    lottoGame.getNumbers()[2] + ".\n" +
                    "Sum: " + sum;

            JOptionPane.showMessageDialog(null, message);

            // If the sum is equal to the user entered value, the user wins and the game ends
            if (sum == userChoice) {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            JOptionPane.showMessageDialog(null, "Congratulations! You won!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! You lost. The computer wins.");
        }
    }
}