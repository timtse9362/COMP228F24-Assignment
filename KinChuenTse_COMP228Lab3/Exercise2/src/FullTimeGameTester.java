public class FullTimeGameTester extends GameTester {
    private static final double BASE_SALARY = 3000;

    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double calcSalary() {
        return BASE_SALARY;
    }
}
