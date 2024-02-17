package lesson2;

import util.ANSI;

/**
 * Thread Life Cycles
 */
public class LessonTwo {

    private boolean logState = false;

    public LessonTwo() {

    }

    public LessonTwo(boolean logState) {
        this.logState = logState;
    }

    public void execute() {
        Runnable r1 = new State(this.logState);
        Thread t1 = new Thread(r1, "Thread 1");
        Runnable r2 = new State(this.logState);
        Thread t2 = new Thread(r2, "Thread 2");
        Runnable r3 = new State(this.logState);
        Thread t3 = new Thread(r3, "Thread 3");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        t3.start();
        try {
            t3.join(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        printState(t1);
        printState(t2);
        printState(t3);

        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
    }

    private void printState(Thread thread) {
        System.out.println(ANSI.ANSI_BLUE.getAnsiCode() + "Name: " + thread.getName() + ANSI.ANSI_RESET.getAnsiCode() + ANSI.ANSI_GREEN.getAnsiCode() + " lesson2.State: " + thread.getState() + ANSI.ANSI_RESET.getAnsiCode());
    }
}
