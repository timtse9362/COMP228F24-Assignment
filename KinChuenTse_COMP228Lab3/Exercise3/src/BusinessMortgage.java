public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageType, int mortgageNumber, String customerName, double amount, int term, double rate) {
        super(mortgageType, mortgageNumber, customerName, amount, term, rate);
    }

    /*@Override
    public double setInterestRate() {
        return 1.0; // 1% over the current prime rate
    }*/
}
