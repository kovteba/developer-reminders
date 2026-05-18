package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// tag::CompletableFutureDemo11[]
public class CompletableFutureDemo11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> what = CompletableFuture.supplyAsync(() -> "What");
        CompletableFuture<String> the = CompletableFuture.supplyAsync(() -> "the");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "future");
        CompletableFuture<String> holds = CompletableFuture.supplyAsync(() -> "holds?");

        String result = Stream.of(what, the, future, holds)
                .map(m -> m.join())
                .collect(Collectors.joining(" "));

        System.out.println(result); //output: What the future holds?
    }
}
// end::CompletableFutureDemo11[]
