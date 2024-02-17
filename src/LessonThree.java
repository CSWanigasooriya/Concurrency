/**
 * Producer/Consumer
 */
public class LessonThree {
    MailBox mailBox = new MailBox();
    Thread consumer;
    Thread producer;

    public void execute() {
        this.consumer = new Thread(new Consumer(mailBox), "Consumer Thread");
        this.producer = new Thread(new Producer(mailBox), "Producer Thread");
        producer.start();
        consumer.start();
        for (int i = 0; i <= 20; i++) {
            printState();
        }
    }

    private void printState() {
        System.out.println("CONSUMER: " + consumer.getState());
        System.out.println("PRODUCER: " + producer.getState());
    }
}
