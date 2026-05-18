package kovteba.concurrency.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// tag::CallableClass2[]
public class CallableClass2 implements Callable<String> {

    private String value;

    public CallableClass2(String value) {
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        return value.toUpperCase();
    }

    public static void main(String[] args) throws Exception {

        try (ExecutorService executor = Executors.newFixedThreadPool(10)){

            Future<String> future = executor.submit(new CallableClass2("Результат з Java потоку"));
            System.out.println(future.get());
            executor.shutdown();
        }
    }
}
// end::CallableClass2[]
