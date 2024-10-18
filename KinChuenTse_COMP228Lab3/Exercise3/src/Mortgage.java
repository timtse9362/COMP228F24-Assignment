public abstract class Mortgage implements MortgageConstants{
    private int mortgageNumber;
    private String customerName;
    private double mortgageAmount;
    private double mortgageRate;
    private int mortgageTerm;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        if (mortgageAmount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed " + MAX_MORTGAGE_AMOUNT);
        }
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageAmount = mortgageAmount;
        this.mortgageTerm = (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) ? term : SHORT_TERM;
        this.mortgageRate = setInterestRate();
    }

    public abstract double setInterestRate();

    public void getMortgageInfo(){
        System.out.printf("Mortgage Number: %s%nCustomer Name: %s%nAmount: $%.2f%nInterest Rate: %.2f%%%nTerm: %d years%nTotal Amount Owed: $%.2f%n",
                mortgageNumber, customerName, mortgageAmount, mortgageRate, mortgageTerm, calculateTotalAmountOwed());
    }
    public double calculateTotalAmountOwed() {
        return mortgageAmount + (mortgageAmount * (mortgageRate / 100) * mortgageTerm);
    }
}
