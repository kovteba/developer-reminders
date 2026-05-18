package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo8[]
public class CompletableFutureDemo8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> {
                    throw new RuntimeException("error in async running");
                }).handle((obj, err) -> {
                    System.out.print(err.getMessage());
                    return 10;
                });

        System.out.println(" "+future.get()); //output java.lang.RuntimeException: error in async running 10
    }
}
// end::CompletableFutureDemo8[]
