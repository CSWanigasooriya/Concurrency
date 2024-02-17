package lesson5;

import util.ANSI;

public class Group implements Runnable {

    private static int number = 1;

    @Override
    public void run() {
        ThreadGroup g2 = new ThreadGroup("TG" + number++);
        for (int i = 0; i < 10; i++) {
            System.out.println(ANSI.ANSI_BLUE.getAnsiCode());
            System.out.println("Thread group name is " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("Thread name is " + Thread.currentThread().getName());
            System.out.println("The name of the parent thread group is " + Thread.currentThread().getThreadGroup().getParent().getName());
            System.out.println("Value of i is " + i);
            System.out.println("Thread Name: " + Thread.currentThread().getName() + "# Thread lesson5.Group Name: " + Thread.currentThread().getThreadGroup().getName() + " # Parent lesson5.Group: " + Thread.currentThread().getThreadGroup().getParent().getName() + " # Super Parent lesson5.Group: " + Thread.currentThread().getThreadGroup().getParent().getParent().getName());
            System.out.println(ANSI.ANSI_RESET.getAnsiCode());
        }
        System.out.println("Thread lesson5.Group Name in Runnable: " + g2.getName() + " # Parent lesson5.Group: " + g2.getParent().getName() + " # Super Parent lesson5.Group: " + g2.getParent().getParent().getName());
    }
}
