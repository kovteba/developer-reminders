package kovteba.concurrency.creation;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// tag::RunnableClass2[]
public class RunnableClass2 implements Runnable {

    static final int NUMBER_OF_THREADS = 10;

    @Override
    public void run() { }

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executor.execute(new RunnableClass2());
        }
        executor.shutdownNow();
        System.out.println("All threads have been started");
    }
}
// end::RunnableClass2[]
