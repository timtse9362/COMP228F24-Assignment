public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber, customerName, amount, term);
    }

    @Override
    public double setInterestRate() {
        return 2.0; // 2% over the current prime rate
    }
}
