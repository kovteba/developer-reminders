package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

// tag::CompletableFutureDemo2[]
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Результат асинхронной задачи";
            }
        }, Executors.newFixedThreadPool(10));

        String result = future.get();
        System.out.println(result);
    }
}
// end::CompletableFutureDemo2[]
