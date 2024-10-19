import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance[] insuranceArray = new Insurance[3]; // Array to hold insurance objects
        int count = 0;

        //For loop to run 3 times to ask user for the insurance information
        for (int i = 0; i < 3; i++) {
            System.out.print("Please enter the insurance type: ");
            String type = scanner.nextLine();
            System.out.print("Please enter the monthly cost: ");
            double monthlyCost = scanner.nextDouble();
            scanner.nextLine();

            if(type.equals("Health")) {
                Health healthInsurance = new Health();
                healthInsurance.insuranceType = type;
                healthInsurance.setInsuranceCost(monthlyCost);
                insuranceArray[i] = healthInsurance;
            }
            else if(type.equals("Life")) {
                Life lifeInsurance = new Life();
                lifeInsurance.insuranceType = type;
                lifeInsurance.setInsuranceCost(monthlyCost);
                insuranceArray[i] = lifeInsurance;
            }
        }

        //To display all the insurance information
        System.out.println("\nInsurance Information:");
        for (int i = 0; i < 3; i++) {
            insuranceArray[i].displayInfo();
        }
        scanner.close();
    }
}