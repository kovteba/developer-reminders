package kovteba.concurrency.creation;

// tag::RunnableClass1[]
public class RunnableClass1 implements Runnable { // implement interface

    private String value;

    public RunnableClass1(String value) {
        this.value = value;
    }

    @Override
    public void run() { // override run method
        System.out.println("Thread with value: " + value + " is running");
    }
    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableClass1("Second")); // create instance of Thread class
        Thread thread2 = new Thread(new RunnableClass1("Third")); // and pass instance of class
        Thread thread3 = new Thread(new RunnableClass1("Fourth")); // which implement interface Runnable

        thread1.start(); // run method start
        thread2.start(); // which will run
        thread3.start(); // overwritten method run
    }
}
// end::RunnableClass1[]
