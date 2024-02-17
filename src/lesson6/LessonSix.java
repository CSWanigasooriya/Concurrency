package lesson6;

public class LessonSix {

    public void execute() {
        ThreadGroup[] groups = new ThreadGroup[6];
        Thread[] threads = new Thread[8];

        threads[0] = Thread.currentThread();
        groups[0] = Thread.currentThread().getThreadGroup();

        threads[1] = new Thread(new Active(), "Thread 1");
        groups[1] = new ThreadGroup("Group A");
        groups[2] = new ThreadGroup("Group B");
        groups[3] = new ThreadGroup("Group C");

        threads[2] = new Thread(groups[1], new Active(), "Thread 2");
        threads[3] = new Thread(groups[1], new Active(), "Thread 3");

        groups[4] = new ThreadGroup("Group B1");
        groups[5] = new ThreadGroup("Group B2");

        threads[4] = new Thread(groups[3], new Active(), "Thread 4");

        threads[5] = new Thread(groups[4], new Active(), "Thread 5");
        threads[6] = new Thread(groups[4], new Active(), "Thread 6");

        threads[7] = new Thread(groups[5], new Active(), "Thread 7");

        for (int i = 1; i < threads.length; i++) {
            threads[i].start();
        }

        int activeThreadCount = groups[0].activeCount();
        int activeThreadGroupCount = groups[0].activeGroupCount();

        Thread[] activeThreads = new Thread[activeThreadCount];
        groups[0].enumerate(activeThreads, true);

        for (Thread thread : activeThreads) {
            if (thread != null)
                System.out.println(thread.getName());
        }

        ThreadGroup[] threadGroups = new ThreadGroup[activeThreadGroupCount];
        groups[0].enumerate(threadGroups, true);

        for (ThreadGroup threadGroup : threadGroups) {
            if (threadGroup != null)
                System.out.println(threadGroup.getName());
        }
    }
}
