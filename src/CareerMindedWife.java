public class CareerMindedWife extends Thread {
    private BankAccount bankAccount;

    private BankAccountMonitor bankAccountMonitor;

    public CareerMindedWife(BankAccount bankAccount, String name) {
        super(name);
        this.bankAccount = bankAccount;
    }

    public CareerMindedWife(BankAccountMonitor bankAccount, String name) {
        super(name);
        this.bankAccountMonitor = bankAccount;
    }


    //Final balance: n/2 (2 * a + (n-1) * d) = 9/2 (2 * 1000 + (9-1) * 1000),
    // n = number of terms, a = first term, d = difference
    @Override
    public void run() {
        int n = 9;
        int d = 1000;
        for (int i = 1; i <= n; i++) {
            if (this.bankAccountMonitor != null) this.bankAccountMonitor.deposit(i * d);
            if (this.bankAccount != null) this.bankAccount.deposit(i * d);
        }
    }
}
