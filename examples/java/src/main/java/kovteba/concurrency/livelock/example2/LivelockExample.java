package kovteba.concurrency.livelock.example2;

// tag::LivelockExample[]
public class LivelockExample {
    static final Bank PARKING_PLACE = new Bank();

    static final User USER = new User();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> PARKING_PLACE.payment(USER));
        t1.start();

        Thread t2 = new Thread(() -> USER.pay(PARKING_PLACE));
        t2.start();
    }
}
// end::LivelockExample[]
