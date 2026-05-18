package kovteba.concurrency;

// tag::ThreadLocalExample[]
public class ThreadLocalExample {
    // Створюємо ThreadLocal змінну
    private static ThreadLocal<String> threadLocalValue = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        // 1. Встановлюємо значення у головному потоці (main)
        threadLocalValue.set("Дані з головного потоку");
        System.out.println(Thread.currentThread().getName() + " бачить: " + threadLocalValue.get());

        // 2. Створюємо інший потік
        Thread anotherThread = new Thread(() -> {
            // Намагаємося отримати доступ до того ж ThreadLocal
            String value = threadLocalValue.get();
            System.out.println(Thread.currentThread().getName() + " бачить: " + value);

            // Встановлюємо своє значення всередині цього потоку
            threadLocalValue.set("Дані з іншого потоку");
            System.out.println(Thread.currentThread().getName() + " тепер має: " + threadLocalValue.get());
        }, "Потік-Б");

        anotherThread.start();
        anotherThread.join(); // Чекаємо на завершення Потоку-Б

        // 3. Перевіряємо, чи змінилося значення у головному потоці
        System.out.println(Thread.currentThread().getName() + " все ще бачить: " + threadLocalValue.get());

        // Обов'язково чистимо за собою
        threadLocalValue.remove();
    }
}
// end::ThreadLocalExample[]
