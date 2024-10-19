public abstract class Insurance { //Abstract Insurance class
    protected String insuranceType; //Instance variable insuranceType
    protected double monthlyCost; //Instance variable monthlyCost

    public String getInsuranceType() { //getInsuranceType to get the insurance type
        return insuranceType;
    }

    public double getMonthlyCost() { //getMonthlyCost to get the monthly cost
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double monthlyCost); //Abstract setInsuranceCost method to set the monthly cost

    public abstract void displayInfo(); //Abstract displayInfo method to display the insurance information
}
