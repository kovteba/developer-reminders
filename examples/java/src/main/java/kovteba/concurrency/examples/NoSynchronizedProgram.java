package kovteba.concurrency.examples;

// tag::NoSynchronizedProgram[]
public class NoSynchronizedProgram {
    public static void main(String[] args) {
        NoSynchronizedCommonResource noSynchronizedCommonResource = new NoSynchronizedCommonResource();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountingThread(noSynchronizedCommonResource));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class NoSynchronizedCommonResource {
    int x = 0;
}

class CountingThread implements Runnable {
    NoSynchronizedCommonResource res;

    CountingThread(NoSynchronizedCommonResource res) {
        this.res = res;
    }

    public void run() {
        res.x = 1;
        for (int i = 1; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
            res.x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
/* OUTPUT
Thread 1 1
Thread 2 1
Thread 3 1
Thread 5 1
Thread 4 1
Thread 5 6
Thread 2 6
Thread 1 6
Thread 3 6
Thread 4 6
Thread 4 11
Thread 2 11
Thread 5 11
Thread 3 11
Thread 1 11
Thread 4 16
Thread 1 16
Thread 3 16
Thread 5 16
Thread 2 16
 */
// end::NoSynchronizedProgram[]