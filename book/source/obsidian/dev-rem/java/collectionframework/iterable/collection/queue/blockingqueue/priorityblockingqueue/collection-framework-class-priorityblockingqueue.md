### PriorityBlockingQueue ^java-collection-framework-priorityblockingqueue

`PriorityBlockingQueue<E>` — це **необмежена потокобезпечна черга з пріоритетом** з пакету `java.util.concurrent`, яка реалізує `BlockingQueue<E>`. Елементи видаляються **у порядку пріоритету** (мінімальний елемент першим — min-heap), а не FIFO. Є потокобезпечним аналогом `PriorityQueue`. Не допускає `null`.

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-priorityblockingqueue|PriorityBlockingQueue<E>]]
```

> [!WARNING]
> `PriorityBlockingQueue` **необмежена** (unbounded). Метод `put()` **ніколи не блокується** — черга росте необмежено. Блокується лише `take()` коли черга порожня. При безконтрольному рості черга може спричинити `OutOfMemoryError`.

> [!WARNING]
> `PriorityBlockingQueue` **не допускає `null`** та **не гарантує FIFO для елементів з однаковим пріоритетом**.

**PriorityBlockingQueue — внутрішня реалізація та паралельний resize** ^java-collection-framework-priorityblockingqueue-internal
`PriorityBlockingQueue` = `PriorityQueue` heap + `ReentrantLock` + `Condition notEmpty`. Немає `notFull` — черга unbounded. Паралельний resize: `lock.unlock()` → CAS на `allocationSpinLock` (тільки один потік розширює) → `new Object[newCap]` → `lock.lock()` → `System.arraycopy`.

**BigO notation для PriorityBlockingQueue** ^java-collection-framework-priorityblockingqueue-class-big-o-notation

| Метод | Складність | Пояснення |
| :--- | :--- | :--- |
| `offer(E e)` / `put(E e)` | O(log n) | Вставка + sift up; `put` ніколи не блокується (unbounded) |
| `take()` | O(log n) | Блокує якщо порожня; після пробудження — sift down |
| `poll()` | O(log n) | Як `take` але повертає `null` якщо порожня |
| `peek()` | O(1) | Повертає `queue[0]` без видалення |
| `size()` | O(1) | Поле `size` під lock |
| `drainTo(Collection c)` | O(n) | Забирає всі елементи; ефективніше ніж n разів `poll` |

#### Внутрішній устрій
`PriorityBlockingQueue` — це **бінарна мінімальна купа** на масиві (як `PriorityQueue`) + **один ReentrantLock** + `Condition notEmpty`:

```java
private transient Object[] queue;              // внутрішній масив-купа
private transient int size;                    // кількість елементів
private transient Comparator<? super E> comparator;

private final ReentrantLock lock = new ReentrantLock();
private final Condition notEmpty = lock.newCondition();

// Немає Condition notFull — черга необмежена!
private transient volatile int allocationSpinLock; // CAS для resize
```

#### Підводні камені

> [!WARNING]
> `PriorityBlockingQueue.put()` **ніколи не блокується** — черга необмежена і росте до `OutOfMemoryError`. Якщо потрібен back-pressure — обмежуй розмір вручну через `Semaphore`.

> [!WARNING]
> Елементи з **однаковим пріоритетом** не мають гарантованого порядку. Внутрішня heap-структура визначає їх порядок, який є непередбачуваним.

> [!NOTE]
> Якщо потрібен FIFO-порядок серед елементів з однаковим пріоритетом — використовуй вторинний компаратор із sequence number.

**FIFO для рівних пріоритетів**
```java
AtomicLong seq = new AtomicLong();
record Task(int priority, long sequence, Runnable action) implements Comparable<Task> {
    public int compareTo(Task other) {
        int c = Integer.compare(priority, other.priority);
        return c != 0 ? c : Long.compare(sequence, other.sequence);
    }
}
```
