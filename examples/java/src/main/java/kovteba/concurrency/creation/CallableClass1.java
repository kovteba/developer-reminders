package kovteba.concurrency.creation;

import java.util.concurrent.Callable;

// tag::CallableClass1[]
public class CallableClass1 implements Callable<String> {

    private String value;

    public CallableClass1(String value) {
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        return value.toUpperCase();
    }

    public static void main(String[] args) throws Exception {

        CallableClass1 value1 = new CallableClass1("value1");
        String call = value1.call();
        System.out.println(call);
    }
}
// end::CallableClass1[]
