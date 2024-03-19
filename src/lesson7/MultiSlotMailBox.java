package lesson7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiSlotMailBox {
    private final Queue<Integer> queue;
    public static final int MAX_SIZE = 10;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition full;
    private final Condition empty;

    public MultiSlotMailBox() {
        super();
        this.queue = new LinkedList<>();
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
    }

    public void put(int value) {
        lock.lock();
        try {
            while (queue.size() == MAX_SIZE) {
                full.await();
            }
            queue.add(value);
            this.empty.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    this.empty.await();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            int value = this.queue.poll();
            this.full.signalAll();
            return value;
        } finally {
            lock.unlock();
        }
    }
}
