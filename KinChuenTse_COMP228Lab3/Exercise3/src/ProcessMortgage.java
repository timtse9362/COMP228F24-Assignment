//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];

        int mortgageNumber, mortgageTerm, mortgageType;
        String customerName;
        double mortgageAmount, mortgageRate;

        System.out.print("Enter the current prime interest rate %: ");
        double currentInterestRate = scanner.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("\nEnter details for Mortgage " + (i + 1) + ":");
            System.out.print("Enter mortgage number: ");
            mortgageNumber = scanner.nextInt();
            System.out.print("Enter customer name: ");
            customerName = scanner.next();
            System.out.print("Enter mortgage amount: ");
            mortgageAmount = scanner.nextDouble();
            System.out.print("Enter mortgage term (1 for short, 3 for medium, 5 for long): ");
            mortgageTerm = scanner.nextInt();
            System.out.print("Enter mortgage type (1 for Business, 2 for Personal): ");
            mortgageType = scanner.nextInt();

            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage("Business", mortgageNumber, customerName, mortgageAmount, mortgageTerm, currentInterestRate + 1.0);
            } else if (mortgageType == 2) {
                mortgages[i] = new PersonalMortgage("Personal", mortgageNumber, customerName, mortgageAmount, mortgageTerm, currentInterestRate + 2.0);
            }
        }

        System.out.println("\nMortgage Details: ");
        for (Mortgage mortgage : mortgages) {
            mortgage.getMortgageInfo();
            System.out.println();
        }
        scanner.close();
    }
}