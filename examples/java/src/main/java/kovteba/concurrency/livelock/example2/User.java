package kovteba.concurrency.livelock.example2;

import lombok.SneakyThrows;

// tag::LivelockUser[]
public class User {
    private boolean moneySent = false;

    @SneakyThrows
    public void pay(Bank bank) {

        while (!bank.isMoneyCome()) {
            System.out.println("User waiting bank");
            Thread.sleep(1000);
        }

        System.out.println("User sent a money");

        this.moneySent = true;
    }

    public boolean isMoneySent() {

        return this.moneySent;
    }
}
// end::LivelockUser[]
