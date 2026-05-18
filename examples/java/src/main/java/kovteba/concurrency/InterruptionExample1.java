package kovteba.concurrency;

import static java.lang.Thread.currentThread;

// tag::InterruptionExample1[]
public class InterruptionExample1 implements Runnable {

    @Override
    public void run() {

        long millisOut = System.currentTimeMillis() + 5000;

        while (!Thread.interrupted()){

            System.out.printf("Running: %s thread.", currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.printf("%s thread was interrupted.", currentThread().getName());
                break;
            }
            if (millisOut <= System.currentTimeMillis()){
                currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        InterruptionExample1 interruptionExample1 = new InterruptionExample1();
        interruptionExample1.run();
    }
}
// end::InterruptionExample1[]