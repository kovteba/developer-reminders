package kovteba.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// tag::AbandonedLockExample[]
public class AbandonedLockExample extends Thread {

    private final Lock firstLock;
    private final Lock secondLock;
    private static int counter = 500;

    public AbandonedLockExample(String name, Lock firstLock, Lock secondLock) {
        this.setName(name);
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    public void run() {

        while(counter > 0) {

            firstLock.lock();
            secondLock.lock();

            if (counter > 0) {
                counter--;
                System.out.println(this.getName() + "; Counter: " + counter);
            }

            if (counter == 10) {
                System.out.println(1/0);
            }

            secondLock.unlock();
            firstLock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();
        new AbandonedLockExample("Thread 1", lock1, lock2).start();
        new AbandonedLockExample("Thread 2", lock2, lock3).start();
        new AbandonedLockExample("Thread 3", lock1, lock3).start();
    }
}
// end::AbandonedLockExample[]
