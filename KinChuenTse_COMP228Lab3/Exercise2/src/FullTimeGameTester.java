public class FullTimeGameTester extends GameTester {
    private double baseSalary = 3000; //Instance double variable to store the base salary value

    public FullTimeGameTester(String name) { //Constructor
        super(name, true);
    }

    @Override
    public double calcSalary() { //Implement the calcSalary
        return baseSalary;
    }
}
