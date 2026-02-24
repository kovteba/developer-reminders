package kovteba.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// tag::CompletableFutureDemo7[]
public class CompletableFutureDemo7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10); // створюємо CompletableFuture, який виконує асинхронну задачу і повертає результат типу Integer. У цьому випадку, задача просто повертає число 10.
        CompletableFuture<Integer> anotherFuture = CompletableFuture.supplyAsync(() -> 2); // створюємо ще один CompletableFuture, який виконує іншу асинхронну задачу і повертає результат типу Integer. У цьому випадку, задача просто повертає число 2.
        CompletableFuture<Integer> result = future.thenCombine(anotherFuture, (a, b) -> a * b); // Створюємо ще один CompletableFuture, який об'єднує результати двох попередніх CompletableFuture (future та anotherFuture) за допомогою методу thenCombine. Цей метод приймає два параметри: інший CompletableFuture (anotherFuture) та функцію (a, b) -> a * b, яка визначає, як об'єднати результати обох CompletableFuture. У цьому випадку, функція просто множить два числа (a та b) і повертає результат.
        System.out.println(result.get()); //output 20
    }
}
// end::CompletableFutureDemo7[]
