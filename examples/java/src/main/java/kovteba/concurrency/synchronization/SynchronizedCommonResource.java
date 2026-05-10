package kovteba.concurrency.synchronization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

// tag::SynchronizedCommonResource[]
@Data
@AllArgsConstructor
public class SynchronizedCommonResource {

    private Integer x;

    @SneakyThrows
    public synchronized void counter() {
        for (int i = 1; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            Thread.sleep(100);
        }
    }
}
// end::SynchronizedCommonResource[]
