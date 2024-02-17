public class MailBox {
    private int counter = 0;
    private int value;
    private boolean locked = false;

    public synchronized void put(int value) {
        while (this.locked) { // Producer must wait until the consumer consumes
            try {
                wait(); // will be called by the current thread, producer will go into WAITING state.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Consumer has consumed and set availability to false.
        this.counter++;
        this.value = value;
        this.locked = true;
        notifyAll(); // notifies all the other threads that it is in the waitset on the mailbox object
        //notify(); // notifies one random thread from the waitset
    }


    public synchronized int get() {
        while (!this.locked) { //wait until producer
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // There is something to consume at this level
        this.locked = false;
        notifyAll();
        return this.value;
    }

    public int count() {
        return this.counter;
    }
}
