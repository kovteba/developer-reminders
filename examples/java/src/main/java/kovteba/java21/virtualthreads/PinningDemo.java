package kovteba.java21.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;

public class PinningDemo {
    public static void main(String[] args) {
        final Object lock = new Object();

//         Создаем экзекутор, который плодит виртуальные потоки
//        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            executor.submit(() -> {
//                synchronized (lock) {
//                    System.out.println(Thread.currentThread() + " зашел в synchronized");
//                    try {
//                        // Имитируем блокирующую операцию (например, запрос в БД)
//                        Thread.sleep(Duration.ofSeconds(2));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(Thread.currentThread() + " вышел из synchronized");
//            });
//        }
    }
}