package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo4[]
public class CompletableFutureDemo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
        future.thenApply(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        });
        future.thenApply(result -> {
            System.out.println(result + ", world!"); //output Hi, world!
            return result;
        });
        future.get();
    }
}
// end::CompletableFutureDemo4[]
