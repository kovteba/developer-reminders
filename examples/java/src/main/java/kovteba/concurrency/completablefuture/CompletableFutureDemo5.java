package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo5[]
public class CompletableFutureDemo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
        future.thenApplyAsync(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        });
        Thread.sleep(100);
    }
}
// end::CompletableFutureDemo5[]
