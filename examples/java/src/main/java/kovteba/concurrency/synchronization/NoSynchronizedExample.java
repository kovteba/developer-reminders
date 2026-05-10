package kovteba.concurrency.synchronization;

import lombok.SneakyThrows;

// tag::NoSynchronizedExample[]
public class NoSynchronizedExample {
    public static void main(String[] args) {
        NoSynchronizedCommonResource noSynchronizedResource = new NoSynchronizedCommonResource(1);
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new NoSynchronizedCounter(noSynchronizedResource));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class NoSynchronizedCounter implements Runnable {
    private NoSynchronizedCommonResource res;

    NoSynchronizedCounter(NoSynchronizedCommonResource res) {
        this.res = res;
    }

    @Override
    @SneakyThrows
    public void run() {

        for (int i = 1; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.getX());
            res.setX(res.getX() + 1);
            Thread.sleep(100);
        }
    }
}
// end::NoSynchronizedExample[]
/*
// tag::NoSynchronizedExampleResult[]
Thread 1 1
Thread 5 1
Thread 4 1
Thread 3 1
Thread 2 1
Thread 1 6
Thread 4 6
Thread 5 6
Thread 2 7
Thread 3 7
Thread 3 11
Thread 4 12
Thread 1 12
Thread 2 12
Thread 5 12
Thread 4 16
Thread 1 17
Thread 5 17
Thread 2 17
Thread 3 17
// end::NoSynchronizedExampleResult[]
*/
