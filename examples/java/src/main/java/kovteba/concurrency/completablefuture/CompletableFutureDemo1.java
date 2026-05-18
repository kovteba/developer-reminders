package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// tag::CompletableFutureDemo1[]
public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                // Имитация длительной работы
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("Я буду работать в отдельном потоке, а не в главном.");
            }
        }, Executors.newFixedThreadPool(10));

// Блокировка и ожидание завершения Future
        future.get();
    }
}
// end::CompletableFutureDemo1[]
