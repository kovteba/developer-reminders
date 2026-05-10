package kovteba.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// tag::ThreadPoolExample1[]
public class ThreadPoolExample1 implements Runnable {

    int i;

    public ThreadPoolExample1(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + i);
    }

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            ThreadPoolExample1 threadPoolExample1 = new ThreadPoolExample1(i);
            pool.execute(threadPoolExample1);
        }

        pool.shutdown();
    }
}
// end::ThreadPoolExample1[]

class ThreadPoolExample1Demo {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            ThreadPoolExample1 threadPoolExample1 = new ThreadPoolExample1(i);
            pool.execute(threadPoolExample1);
        }

        pool.shutdown();
    }
}
