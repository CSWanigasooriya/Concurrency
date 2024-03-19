package lesson8;

import lesson4.BankAccountMonitor;

public class HouseBasedHusband implements Runnable {

    private final BankAccount bankAccount;

    public HouseBasedHusband(BankAccount bankAccount) {
        super();
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() { // HBH threads body
        for (int i = 1; i <= 10; i++) {
            try {
                bankAccount.withdraw(10000);// if IllegalArgumentException
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}

