import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.00); // Create a new Account object with initial deposit $1000
        ArrayList<Transaction> transactions = new ArrayList<>(5);

        // Create 5 transactions
        Transaction traction1 = new Transaction(account, "deposit", 200);
        transactions.add(traction1);
        Transaction traction2 = new Transaction(account, "withdraw", 150);
        transactions.add(traction2);
        Transaction traction3 = new Transaction(account, "withdraw", 300);
        transactions.add(traction3);
        Transaction traction4 = new Transaction(account, "deposit", 50);
        transactions.add(traction4);
        Transaction traction5 = new Transaction(account, "withdraw", 500);
        transactions.add(traction5);


        // Using ExecutorService to manage threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Execute transactions
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        executor.shutdown(); // Shutdown executor service
        while (!executor.isTerminated()) {
            // Wait for all tasks to finish so that the getBalance() can be run at the last priority
        }

        System.out.printf("Final Balance: %.2f%n", account.getBalance());
    }
}