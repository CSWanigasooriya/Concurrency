package lesson3;

import util.ANSI;

public class Producer implements Runnable {

    private final MailBox box;

    public Producer(MailBox box) {
        super();
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            box.put(i);
            System.out.println(ANSI.ANSI_RED.getAnsiCode() + Thread.currentThread().getName() + ": PUT[" + i + "]" + " #" + box.count() + ANSI.ANSI_RESET.getAnsiCode());
        }
    }
}
