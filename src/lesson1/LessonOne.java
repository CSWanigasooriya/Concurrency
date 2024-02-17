package lesson1;

import util.ANSI;

/**
 * Issues faced with shared resources.
 */
public class LessonOne {
    public void execute() {
        double defaultBalance = 0;
        String accountNumber = "-";
        printAccountDetails(defaultBalance, accountNumber);
        BankAccount bankAccount = new BankAccount(defaultBalance, accountNumber);
        Runnable hbhRunnable = new HouseBasedHusband(bankAccount);
        Thread hbhThread = new Thread(hbhRunnable, "House Based Husband");
        Thread cmwThread = new CareerMindedWife(bankAccount, "Career Minded Wife");
        cmwThread.start();
        hbhThread.start();
    }

    private void printAccountDetails(double defaultBalance, String accountNumber) {
        String blueBackgroundAnsiCode = ANSI.ANSI_BLUE_BACKGROUND.getAnsiCode();
        String resetAnsiCode = ANSI.ANSI_RESET.getAnsiCode();
        System.out.println(blueBackgroundAnsiCode + "Default Balance    : " + defaultBalance + resetAnsiCode);
        System.out.println(blueBackgroundAnsiCode + "Account Number     : " + accountNumber + resetAnsiCode);
    }
}
