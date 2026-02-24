package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo9[]
public class CompletableFutureDemo9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture.supplyAsync(() -> {throw new RuntimeException("error in async running");})
                .exceptionally(err -> (5))
                .thenAccept(System.out::println); //output 5
    }
}
// end::CompletableFutureDemo9[]
