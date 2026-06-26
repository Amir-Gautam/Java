
class BankAccount {
    private final String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited Rs. " + amount + ". New balance: Rs. " + balance);
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew Rs. " + amount + ". New balance: Rs. " + balance);
    }

    double getBalance() {
        return balance;
    }

    String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MIN_THRESHOLD = 1000;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void withdraw(double amount) {
        if (getBalance() - amount < MIN_THRESHOLD) {
            System.out.println("Withdrawal denied. Balance cannot fall below " + MIN_THRESHOLD);
            return;
        }
        super.withdraw(amount);
    }

    void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of Rs. " + interest + " added.");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("NIC-10234567", 5000, 5);
        account.deposit(1500);
        account.addInterest();
        account.withdraw(5500);
        account.withdraw(500);
        System.out.println("Final balance: Rs. " + account.getBalance());
    }
}
