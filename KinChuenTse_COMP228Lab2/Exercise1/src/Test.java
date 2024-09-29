import javax.swing.*;
import java.util.Random;

public class Test {
    private String[] questionsArray = {
            "What is the keyword used to define a class in Java?",
            "Which of the following is a valid identifier in Java?",
            "What is the correct way to call a static method in a class?",
            "Which of the following is an example of method overloading?",
            "What is the scope of a variable declared inside a method?"
    };

    private String[][] optionsArray = {
            {"class", "object", "module", "function"},
            {"myVariable", "2ndVariable", "my-variable", "my variable"},
            {"ClassName.methodName()", "ClassName::methodName()", "methodName.ClassName()", "methodName()"},
            {"public void myMethod()", "public void myMethod(int a)", "public void myMethod(int a, String b)", "All of the above"},
            {"Only within the method", "Within the class", "Within the package", "Globally"}
    };

    private int[] answers = {0, 0, 0, 3, 0}; // Correct answer indices

    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private Random randomObject = new Random();

    // Method to interact with the user
    public void inputAnswer() {
        for (int i = 0; i < questionsArray.length; i++) {
            simulateQuestion(i);
        }
        displayResults();
    }

    // Method to simulate each question
    private void simulateQuestion(int index) {
        String question = questionsArray[index];
        String[] opts = optionsArray[index];
        StringBuilder optionsString = new StringBuilder();

        for (int i = 0; i < opts.length; i++) {
            optionsString.append((i + 1) + ": " + opts[i] + "\n");
        }

        String response = JOptionPane.showInputDialog(null,
                question + "\n" + optionsString.toString(), "Quiz", JOptionPane.QUESTION_MESSAGE);

        checkAnswer(index, response);
    }

    // Method to check the answer
    private void checkAnswer(int index, String response) {
        String randomMessage;
        try {
            int answerIndex = Integer.parseInt(response) - 1;
            if (answerIndex == answers[index]) {
                correctAnswers++;
                randomMessage = generateMessage(true);
                JOptionPane.showMessageDialog(null, randomMessage, "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                incorrectAnswers++;
                randomMessage = generateMessage(false);
                JOptionPane.showMessageDialog(null, randomMessage +
                        " The correct answer was: " + (answers[index] + 1), "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 4.", "Error", JOptionPane.ERROR_MESSAGE);
            incorrectAnswers++;
        }
    }

    // Method to display a random congratulatory message
    private String generateMessage(boolean isCorrect) {
        String message;
        if(isCorrect) {
            switch (randomObject.nextInt(4)) {
                case 0:
                    message = "Excellent!";
                    break;
                case 1:
                    message = "Good!";
                    break;
                case 2:
                    message = "Keep up the good work!";
                    break;
                case 3:
                    message = "Very good. Nice work!";
                    break;
                default:
                    message = ""; // Should never reach here
            }
        }
        else{
            switch (randomObject.nextInt(4)) {
                case 0:
                    message = "No. Please try again.";
                    break;
                case 1:
                    message = "Wrong. Try once more.";
                    break;
                case 2:
                    message = "The answer is incorrect. Don't give up!";
                    break;
                case 3:
                    message = "No. Keep trying again";
                    break;
                default:
                    message = ""; // Should never reach here
            }
        }
        return message;
    }

    // Method to display results at the end of the test
    private void displayResults() {
        int totalQuestions = questionsArray.length;
        double percentage = (double) correctAnswers / totalQuestions * 100;
        String resultMessage = "Correct Answers: " + correctAnswers +
                "\nIncorrect Answers: " + incorrectAnswers +
                "\nPercentage: " + String.format("%.2f", percentage) + "%";
        JOptionPane.showMessageDialog(null, resultMessage, "Test Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
