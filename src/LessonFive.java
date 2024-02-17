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

        ThreadGroup group1 = new ThreadGroup("G1");
        Thread t1 = new Thread(group1, () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(ANSI.ANSI_BLUE.getAnsiCode());
                System.out.println("Thread group name is " + Thread.currentThread().getThreadGroup().getName());
                System.out.println("Thread name is " + Thread.currentThread().getName());
                System.out.println("The name of the parent thread group is " + Thread.currentThread().getThreadGroup().getParent().getName());
                System.out.println("Value of i is " + i);
                System.out.println(ANSI.ANSI_RESET.getAnsiCode());
            }
        }, "T1");

        t1.setDaemon(true);
        t1.start();
        System.out.println("Name of the thread is " + t1.getName() + " belongs to thread Group of " + t1.getThreadGroup().getName() + " the parent group name is " + t1.getThreadGroup().getParent().getName());
        System.out.println("isDaemon -> " + t1.isDaemon());
    }
}
