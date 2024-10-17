public class Health extends Insurance{
    public Health(){
        this.insuranceType = "Health";
    }

    @Override
    public void setInsuranceCost(double monthlyCost){
        this.monthlyCost = monthlyCost;
    }

    @Override
    public void displayInfo(){
        System.out.printf("Insurance Type: %s%nMonthly Cost: $%.2f%n", this.insuranceType, this.monthlyCost);
    }
}
