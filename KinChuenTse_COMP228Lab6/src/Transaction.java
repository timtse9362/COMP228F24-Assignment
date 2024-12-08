import java.util.Random;

public class Transaction implements Runnable {
    private Account account;
    private String transactionType;
    private double amount;

    public Transaction(Account account, String transactionType, double amount) { //Transaction constructor
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() { //The run() method to perform deposit or withdraw action of an object
        if ("deposit".equalsIgnoreCase(transactionType)) {
            account.deposit(amount);
        } else if ("withdraw".equalsIgnoreCase(transactionType)) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type!");
        }
    }
}