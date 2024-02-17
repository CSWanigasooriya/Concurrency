package lesson4;

import util.ANSI;

public class BankAccountMonitor {

    private final String accountNo;
    private double balance;
    private int count;


    public BankAccountMonitor(double balance, String accountNo) {
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
        System.out.println(this.count + "- AVAILABILITY [WITHDRAW#START]: " + (amount > this.balance));

        while (amount > this.balance) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            System.out.println(ANSI.ANSI_GREEN.getAnsiCode() + Thread.currentThread().getId() + ": " + "[" + Thread.currentThread().getPriority() + "] " + Thread.currentThread().getName() + " balance after withdraw is " + this.getBalance() + ANSI.ANSI_RESET.getAnsiCode());
        } else {
            throw new IllegalArgumentException("Insufficient funds or Invalid Amount #" + " Amount: " + amount + ", Balance: " + balance);
        }

        System.out.println(this.count + "- AVAILABILITY [WITHDRAW#END]: " + (amount > this.balance));
        notifyAll();
    }


    public synchronized void deposit(double amount) {
        System.out.println(this.count + "- AVAILABILITY [DEPOSIT#START]: " + (amount < this.balance));
        while (amount < this.balance) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (amount > 0) {
            this.balance += amount;
            System.out.println(ANSI.ANSI_RED.getAnsiCode() + Thread.currentThread().getId() + ": " + "[" + Thread.currentThread().getPriority() + "] " + Thread.currentThread().getName() + " the balance after deposit is " + this.getBalance() + ANSI.ANSI_RESET.getAnsiCode());
        } else {
            throw new IllegalArgumentException("Invalid Amount. Amount cannot be ZERO or lesser");
        }

        System.out.println(this.count + "- AVAILABILITY [DEPOSIT#END]: " + (amount < this.balance));
        notifyAll();
        this.count++;
    }
}
