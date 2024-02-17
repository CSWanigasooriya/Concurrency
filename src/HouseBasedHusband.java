public class HouseBasedHusband implements Runnable {

    private BankAccount bankAccount;
    private BankAccountMonitor bankAccountMonitor;

    public HouseBasedHusband(BankAccount bankAccount) {
        super();
        this.bankAccount = bankAccount;
    }

    public HouseBasedHusband(BankAccountMonitor bankAccount) {
        super();
        this.bankAccountMonitor = bankAccount;
    }

    //Final balance: n/2 (2 * a + (n-1) * d) = 9/2 (2 * 1000 + (9-1) * 1000),
    // n = number of terms, a = first term, d = difference
    @Override
    public void run() {
        int n = 9;
        int d = 1000;
        for (int i = 1; i <= n; i++) {
            if (this.bankAccountMonitor != null) this.bankAccountMonitor.withdraw(i * d);
            if (this.bankAccount != null) this.bankAccount.withdraw(i * d);
        }
    }
}
