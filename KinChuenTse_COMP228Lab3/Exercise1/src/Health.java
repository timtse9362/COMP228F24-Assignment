public class Health extends Insurance{

    public Health(){ //Constructor
        this.insuranceType = "Health";
    }

    @Override
    public void setInsuranceCost(double monthlyCost){ //Implement the abstract setInsuranceCost method
        this.monthlyCost = monthlyCost;
    }

    @Override
    public void displayInfo(){ //Implement the abstract displayInfo method
        System.out.printf("Insurance Type: %s%nMonthly Cost: $%.2f%n", this.getInsuranceType(), this.getMonthlyCost());
    }
}
