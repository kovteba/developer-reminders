package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo10[]
public class CompletableFutureDemo10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture what = CompletableFuture.supplyAsync(() -> "What");
        CompletableFuture the = CompletableFuture.supplyAsync(() -> "the");
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "future");
        CompletableFuture holds = CompletableFuture.supplyAsync(() -> "holds");

        CompletableFuture<Void> all = CompletableFuture.allOf(what, the, future, holds);

        all.get();

        System.out.println(what.isDone()); //true
        System.out.println(what.isDone()); //true
        System.out.println(what.isDone()); //true
        System.out.println(what.isDone()); //true
    }
}
// end::CompletableFutureDemo10[]
