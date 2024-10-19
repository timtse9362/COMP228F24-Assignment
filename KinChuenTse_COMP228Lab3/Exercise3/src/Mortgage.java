public abstract class Mortgage implements MortgageConstants{
    private int mortgageNumber; //Instance variable mortgageNumber
    private String customerName; //Instance variable customerName
    private double mortgageAmount; //Instance variable mortgageAmount
    private double mortgageRate; //Instance variable mortgageRate
    private int mortgageTerm; //Instance variable mortgageTerm
    private String mortgageType; //Instance variable mortgageType


    public Mortgage(String mortgageType,int mortgageNumber, String customerName, double mortgageAmount, int term, double mortgageRate) { //Constructor
        if (mortgageAmount > maxMortgageAmount) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed " + maxMortgageAmount);
        }
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageAmount = mortgageAmount;
        this.mortgageTerm = (term == shortTerm || term == mediumTerm || term == longTerm) ? term : shortTerm;
        this.mortgageRate = mortgageRate;
        this.mortgageType = mortgageType;
    }

    //public abstract double setInterestRate();

    public void getMortgageInfo(){ //getMortgageInfo to show the mortgage information
        System.out.printf("Mortgage Type: %s%nMortgage Number: %s%nCustomer Name: %s%nAmount: $%.2f%nInterest Rate: %.2f%%%nTerm: %d years%nTotal Amount Owed: $%.2f%n",
                mortgageType, mortgageNumber, customerName, mortgageAmount, mortgageRate, mortgageTerm, calculateTotalAmount());
    }
    public double calculateTotalAmount() { //calculateTotalAmount method to calculate the total mortgage amount
        return mortgageAmount + (mortgageAmount * (mortgageRate / 100) * mortgageTerm);
    }
}
