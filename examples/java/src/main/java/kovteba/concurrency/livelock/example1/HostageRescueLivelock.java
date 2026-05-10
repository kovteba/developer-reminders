package kovteba.concurrency.livelock.example1;

// tag::HostageRescueLivelock[]
public class HostageRescueLivelock {
    static final Police police = new Police();

    static final Criminal criminal = new Criminal();

    public static void main(String[] args) {


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                police.giveRansom(criminal);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                criminal.releaseHostage(police);
            }
        });
        t2.start();
    }
}
// end::HostageRescueLivelock[]
