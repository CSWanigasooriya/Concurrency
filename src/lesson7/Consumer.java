package lesson7;

public class Consumer implements Runnable{
    private final MultiSlotMailBox multiSlotMailBox;

    public Consumer(MultiSlotMailBox multiSlotMailBox){
        super();
        this.multiSlotMailBox = multiSlotMailBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = this.multiSlotMailBox.get();
            System.out.println(Thread.currentThread().getName() + " Consumed: " + value);
        }
    }
}
