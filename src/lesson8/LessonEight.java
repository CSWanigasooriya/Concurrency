package lesson8;

public class LessonEight {

    public void execute() {
        BankAccount bankAccountObj = new BankAccount(0, "20020021");
        Runnable hbhObj = new HouseBasedHusband(bankAccountObj);
        Thread hbhThread = new Thread(hbhObj, "House Based Husband");
        Thread cmwThread = new CareerMindedWife(bankAccountObj, "Career Minded Wife");

        cmwThread.start(); // when the thread is started only it enters RUNNABLE state
        hbhThread.start();
    }
}
