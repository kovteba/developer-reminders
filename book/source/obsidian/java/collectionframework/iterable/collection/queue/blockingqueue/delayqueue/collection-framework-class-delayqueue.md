### DelayQueue ^java-collection-framework-delayqueue

`DelayQueue<E extends Delayed>` — це **необмежена блокуюча черга** з пакету `java.util.concurrent` де елементи стають доступними лише **після закінчення їх затримки**. Елементи повинні реалізовувати інтерфейс `Delayed`. Внутрішньо заснована на `PriorityQueue`.

* `BlockingQueue<E>` — блокуючі операції
* `Iterable<E>`, `Collection<E>`, `Serializable`

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-delayqueue|DelayQueue<E extends Delayed>]]
```

**Інтерфейс Delayed** ^java-collection-framework-delayqueue-delayed-interface
Кожен елемент `DelayQueue` повинен реалізовувати `Delayed`:

```java
public interface Delayed extends Comparable<Delayed> {
    long getDelay(TimeUnit unit);
}
```

**DelayQueue — leader-follower pattern та точне очікування** ^java-collection-framework-delayqueue-leader-follower
Leader-follower: тільки один потік (leader) викликає `available.awaitNanos(delay)` — чекає **точно** до моменту дозрівання елемента. Усі інші потоки (followers) викликають `available.await()` без таймауту. Коли leader прокидається і забирає елемент → `available.signal()` будить наступний follower.

**BigO notation для DelayQueue** ^java-collection-framework-delayqueue-big-o-notation

| Метод | Складність | Пояснення |
| :--- | :--- | :--- |
| `offer(E e)` / `put(E e)` | O(log n) | Вставка в PriorityQueue + sift up; `put` ніколи не блокується (unbounded) |
| `take()` | O(log n) | Блокує поки `getDelay() <= 0`; sift down після видалення |
| `poll()` | O(log n) | Повертає `null` якщо черга порожня АБО перший елемент ще не "дозрів" |
| `peek()` | O(1) | Повертає перший елемент (можливо ще не дозрілий) |
| `size()` | O(1) | Кількість ВСІХ елементів (включно з не-дозрілими) |

#### Внутрішній устрій
`DelayQueue` містить `PriorityQueue` і один `ReentrantLock`:

```java
private final transient ReentrantLock lock = new ReentrantLock();
private final PriorityQueue<E> q = new PriorityQueue<E>();
private final Condition available = lock.newCondition();
private Thread leader; // потік що чекає на наступний елемент
```

#### Практичні застосування

**Кеш з TTL (Time-To-Live)**
`DelayQueue` ідеально підходить для реалізації кешу з автоматичним видаленням об'єктів після завершення терміну їх життя.

**Планувальник відкладених задач**
`ScheduledThreadPoolExecutor` використовує аналогічний механізм всередині — `DelayedWorkQueue`.

#### Підводні камені

> [!WARNING]
> `getDelay()` повинен використовувати `System.nanoTime()` (монотонний годинник), а НЕ `System.currentTimeMillis()`.

> [!WARNING]
> `take()` блокується навіть якщо черга **не порожня** — якщо всі наявні елементи ще не "дозріли" (`getDelay() > 0`).

> [!WARNING]
> `DelayQueue` **не допускає `null`**. Порядок між елементами визначається виключно через `Delayed.compareTo()`.
