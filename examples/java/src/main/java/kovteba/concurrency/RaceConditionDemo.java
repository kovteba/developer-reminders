package kovteba.concurrency;

// tag::RaceConditionDemo[]
public class RaceConditionDemo {
    int counter = 0;
    public void incrementCounter(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter++;
    }
    public int getCounter(){
        return counter;
    }
    public static void main(String[] args) {
        RaceConditionDemo rc = new RaceConditionDemo();

        for(int i = 0; i < 10; i++){
            new Thread(() -> {
                rc.incrementCounter();
                System.out.println("value for " + Thread.currentThread().getName() + " - " + rc.getCounter());
            }).start();
        }
    }
}
// end::RaceConditionDemo[]
