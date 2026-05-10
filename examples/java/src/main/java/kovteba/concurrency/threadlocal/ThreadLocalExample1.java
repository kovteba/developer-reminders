package kovteba.concurrency.threadlocal;

// tag::ThreadLocalExample1[]
public class ThreadLocalExample1 implements Runnable {

    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();

    @Override
    public void run() {
        counter++;

        if (threadLocalCounter.get() == null) {
            threadLocalCounter.set(0);
        } else {
            threadLocalCounter.set(threadLocalCounter.get() + 1);
        }

        System.out.println("Counter : " + counter);
        System.out.println("ThreadLocalCounter : " + threadLocalCounter.get());
    }
}
// end::ThreadLocalExample1[]

class ThreadLocalExamples1Demo {
    public static void main(String[] args) {
        ThreadLocalExample1 thread = new ThreadLocalExample1();

        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);

        t1.start();
        t2.start();
        t3.start();
    }
}
