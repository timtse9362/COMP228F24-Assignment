public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber, customerName, amount, term);
    }

    @Override
    public double setInterestRate() {
        return 1.0; // 1% over the current prime rate
    }
}
