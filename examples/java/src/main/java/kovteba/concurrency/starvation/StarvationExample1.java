package kovteba.concurrency.starvation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// tag::StarvationExample1[]
public class StarvationExample1 extends Thread {

    private final Lock firstLock;
    private final Lock secondLock;
    private static int counter = 500_000;

    public StarvationExample1(String name, Lock firstLock, Lock secondLock) {
        this.setName(name);
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    public void run() {
        int innerCounter = 0;
        while(counter > 0) {

            // pick up chopsticks
            firstLock.lock();
            secondLock.lock();

            try {
                if (counter > 0) {
                    counter--;
                    innerCounter++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
            }
        }

        System.out.println(this.getName() + " inner: " + innerCounter);
    }

    public static void main(String[] args) {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        for (int i = 0; i < 500; i++) {
            new StarvationExample1("Thread-" + i, lock1, lock2).start();
        }
    }
}
// end::StarvationExample1[]
