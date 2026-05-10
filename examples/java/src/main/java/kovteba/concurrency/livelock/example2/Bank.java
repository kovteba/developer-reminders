package kovteba.concurrency.livelock.example2;

import lombok.SneakyThrows;

// tag::LivelockBank[]
public class Bank {
    private boolean moneyCome = false;

    @SneakyThrows
    public void payment(User user) {

        while (!user.isMoneySent()) {
            System.out.println("Bank waiting user");
            Thread.sleep(1000);
        }

        System.out.println("Bank received money.");

        this.moneyCome = true;
    }

    public boolean isMoneyCome() {

        return this.moneyCome;
    }
}
// end::LivelockBank[]
