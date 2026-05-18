package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo6[]
public class CompletableFutureDemo6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10).thenCompose(result -> CompletableFuture.supplyAsync(() -> result * 2))
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result * 5));
        System.out.println(future.get()); //output 100
    }
}
// end::CompletableFutureDemo6[]
