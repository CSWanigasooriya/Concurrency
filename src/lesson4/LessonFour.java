package lesson4;

import lesson1.CareerMindedWife;
import lesson1.HouseBasedHusband;
import util.ANSI;

/**
 * Apply producer/consumer to CMW & HBH
 */
public class LessonFour {
    public void execute() {
        double defaultBalance = 0;
        String accountNumber = "-";
        printAccountDetails(defaultBalance, accountNumber);
        BankAccountMonitor bankAccount = new BankAccountMonitor(defaultBalance, accountNumber);
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
