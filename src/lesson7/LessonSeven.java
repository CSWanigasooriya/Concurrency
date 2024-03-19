package lesson7;

public class LessonSeven {

    public void execute() {
        MultiSlotMailBox multiSlotMailBox = new MultiSlotMailBox();

        Thread[] producers = new Thread[3];
        Thread[] consumers = new Thread[5];

        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(multiSlotMailBox), "Producer Thread: " + i);
            producers[i].start();
        }

        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new Consumer(multiSlotMailBox), "Consumer Thread: " + i);
            consumers[i].setDaemon(true);
            consumers[i].start();
        }
    }
}
