import util.ANSI;

public class BankAccount {


    private final String accountNo;
    private double balance;


    public BankAccount(double balance, String accountNo) {

        super();
        this.balance = balance;
        this.accountNo = accountNo;

    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNo() {
        return accountNo;
    }


    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            System.out.println(ANSI.ANSI_GREEN.getAnsiCode() + Thread.currentThread().getId() + ": " + "[" + Thread.currentThread().getPriority() + "] " + Thread.currentThread().getName() + " balance after withdraw is " + this.getBalance() + ANSI.ANSI_RESET.getAnsiCode());
        } else {
            throw new IllegalArgumentException("Insufficient funds or Invalid Amount #" + " Amount: " + amount + ", Balance: " + balance);
        }
    }


    public synchronized void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(ANSI.ANSI_RED.getAnsiCode() + Thread.currentThread().getId() + ": " + "[" + Thread.currentThread().getPriority() + "] " + Thread.currentThread().getName() + " the balance after deposit is " + this.getBalance() + ANSI.ANSI_RESET.getAnsiCode());
        } else {
            throw new IllegalArgumentException("Invalid Amount. Amount cannot be ZERO or lesser");
        }
    }

}