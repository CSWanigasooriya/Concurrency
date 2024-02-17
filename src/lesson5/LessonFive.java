package lesson5;

import util.ANSI;

/**
 * Thread groups
 */
public class LessonFive {
    public void execute() {
        System.out.println(ANSI.ANSI_GREEN.getAnsiCode());
        System.out.println("Name of the thread is " + Thread.currentThread().getName());
        System.out.println("Belongs to thread group of " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("The parent group name is " + Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println(ANSI.ANSI_RESET.getAnsiCode());

        ThreadGroup g1 = new ThreadGroup("G1");

        Thread t1 = new Thread(g1, new Group(), "T1");

        t1.setDaemon(true);
        t1.start();
        System.out.println("Name of the thread is " + t1.getName() + " belongs to thread lesson5.Group of " + t1.getThreadGroup().getName() + " the parent group name is " + t1.getThreadGroup().getParent().getName());
        System.out.println("isDaemon -> " + t1.isDaemon());


        Thread t2 = new Thread(g1, new Group(), "T2");

        t2.start();

    }
}
