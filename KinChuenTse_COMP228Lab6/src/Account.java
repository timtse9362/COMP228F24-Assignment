public class Account {
    private double balance;

    public Account(double initialBalance) { //Account constructor
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) { //The synchronized deposit method to ensure thread safe
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: %.2f. New Balance: %.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public synchronized void withdraw(double amount) { //The synchronized withdraw method to ensure thread safe
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f. New Balance: %.2f%n", amount, balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public double getBalance() { //The getBalance() method to show the final balance
        return balance;
    }
}