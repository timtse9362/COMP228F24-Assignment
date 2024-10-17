import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        GameTester tester = null;

        System.out.println("Choose Game Tester Type:");
        System.out.print("1. Full-Time, 2. Part-Time ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (choice == 1) {
            System.out.print("Enter the name of the Full-Time Game Tester: ");
            String name = scanner.nextLine();
            tester = new FullTimeGameTester(name);
        }
        else if (choice == 2) {
            System.out.print("Enter the name of the Part-Time Game Tester: ");
            String name = scanner.nextLine();
            System.out.print("Enter the hours worked: ");
            int hours = scanner.nextInt();
            tester = new PartTimeGameTester(name, hours);
        }

        System.out.println("Game Tester Name: " + tester.gameTesterName);
        System.out.println("Salary: $" + tester.calcSalary());

    }
}