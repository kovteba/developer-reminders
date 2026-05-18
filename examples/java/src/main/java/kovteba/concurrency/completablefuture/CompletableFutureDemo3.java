package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo3[]
public class CompletableFutureDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
        future.thenAccept(result -> System.out.println(result));
        future.get();
    }
}
// end::CompletableFutureDemo3[]
