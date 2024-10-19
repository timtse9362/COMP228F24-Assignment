public class PartTimeGameTester extends GameTester {
    private double hoursWorked; //Instance variable

    public PartTimeGameTester(String name, double hoursWorked) { //Constructor
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calcSalary() { //Implement the calcSalary
        return hoursWorked * 20; // $20 per hour
    }
}