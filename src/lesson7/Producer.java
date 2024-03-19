package lesson7;

public class Producer implements Runnable {
    private final MultiSlotMailBox multiSlotMailBox;

    public Producer(MultiSlotMailBox multiSlotMailBox) {
        super();
        this.multiSlotMailBox = multiSlotMailBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            multiSlotMailBox.put(i);
            System.out.println(Thread.currentThread().getName() + " Produced: " + i);
        }
    }
}
