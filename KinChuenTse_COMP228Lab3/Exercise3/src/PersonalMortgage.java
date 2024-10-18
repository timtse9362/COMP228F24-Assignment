public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageType, int mortgageNumber, String customerName, double amount, int term, double rate) {
        super(mortgageType, mortgageNumber, customerName, amount, term, rate);
    }

    /*@Override
    public double setInterestRate() {
        return 2.0; // 2% over the current prime rate
    }*/
}
