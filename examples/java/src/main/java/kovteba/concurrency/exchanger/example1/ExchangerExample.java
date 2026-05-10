package kovteba.concurrency.exchanger.example1;

import java.util.concurrent.Exchanger;

// tag::ExchangerExample[]
public class ExchangerExample {
    
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();
        Thread thread1 = new Thread(new Thread1(ex));
        thread1.setName("Thread 1");
        thread1.start();
        Thread thread2 = new Thread(new Thread2(ex));
        thread2.setName("Thread 2");
        thread2.start();
    }
}

class Thread1 implements Runnable {
    Exchanger<String> exchanger;
    String message;

    Thread1(Exchanger<String> ex) {
        this.exchanger = ex;
        message = "Hello Java!";
    }

    @Override
    public void run() {

        try {
            message = exchanger.exchange(message);
            System.out.printf("%s has received: %s \n", Thread.currentThread().getName(), message);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Thread2 implements Runnable {
    Exchanger<String> exchanger;
    String message;

    Thread2(Exchanger<String> ex) {
        this.exchanger = ex;
        message = "Hello World!";
    }

    @Override
    public void run() {

        try {
            message = exchanger.exchange(message);
            System.out.printf("%s has received: %s \n", Thread.currentThread().getName(), message);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
//output
//Thread 2 has received: Hello Java!
//Thread 1 has received: Hello World!
// end::ExchangerExample[]
