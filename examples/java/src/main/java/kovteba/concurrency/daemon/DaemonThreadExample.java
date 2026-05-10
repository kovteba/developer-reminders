package kovteba.concurrency.daemon;

import lombok.AllArgsConstructor;
import lombok.Data;

// tag::DaemonThreadExample[]
public class DaemonThreadExample {
    public static void main(String[] args) {
        var ordinalCounter = new CounterThread(100, "Ordinal");
        var daemonCounter = new CounterThread(1_000_000, "Daemon");
        daemonCounter.setDaemon(true);
        ordinalCounter.start();
        daemonCounter.start();
    }
}
// end::DaemonThreadExample[]

// tag::CounterThread[]
@Data
@AllArgsConstructor
class CounterThread extends Thread {

    private Integer counter;
    private String threadName;

    @Override
    public void run() {
        System.out.printf("%s running counter... \n", threadName);
        for (int i = 0; i < counter; i++) {

        }
        System.out.printf("%s counter finished... \n", threadName);
    }
}
// end::CounterThread[]
/*
// tag::result[]
Daemon running counter...
Ordinal running counter...
Ordinal counter finished...
// end::result[]
*/
