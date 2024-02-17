package lesson3;

import util.ANSI;

public class Consumer implements Runnable {

    private final MailBox box;

    public Consumer(MailBox box) {
        super();
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = box.get();
            System.out.println(ANSI.ANSI_GREEN.getAnsiCode() + Thread.currentThread().getName() + ": GET[" + value + "]" + " #" + box.count() + ANSI.ANSI_RESET.getAnsiCode());
        }
    }
}
