package kovteba.concurrency.synchronization;

import lombok.SneakyThrows;

// tag::SynchronizedExample[]
public class SynchronizedExample {
    public static void main(String[] args) {
        NoSynchronizedCommonResource noSynchronizedResource = new NoSynchronizedCommonResource(1);
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new SynchronizedCounter(noSynchronizedResource));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class SynchronizedCounter implements Runnable {
    private NoSynchronizedCommonResource res;

    SynchronizedCounter(NoSynchronizedCommonResource res) {
        this.res = res;
    }

    @Override
    @SneakyThrows
    public void run() {

        synchronized (res) {
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.getX());
                res.setX(res.getX() + 1);
                Thread.sleep(100);
            }
        }
    }
}
// end::SynchronizedExample[]
/*
// tag::SynchronizedExampleResult[]
Thread 1 1
Thread 1 2
Thread 1 3
Thread 1 4
Thread 5 5
Thread 5 6
Thread 5 7
Thread 5 8
Thread 4 9
Thread 4 10
Thread 4 11
Thread 4 12
Thread 3 13
Thread 3 14
Thread 3 15
Thread 3 16
Thread 2 17
Thread 2 18
Thread 2 19
Thread 2 20
// end::SynchronizedExampleResult[]
*/
