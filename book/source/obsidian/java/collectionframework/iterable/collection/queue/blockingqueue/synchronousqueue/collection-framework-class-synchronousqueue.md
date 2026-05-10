### SynchronousQueue ^java-collection-framework-synchronousqueue

`SynchronousQueue<E>` — це **черга нульової ємності** з пакету `java.util.concurrent`. Не зберігає жодного елемента — кожен `put()` блокується поки інший потік не викличе `take()`, і навпаки. Фактично це **точка рандеву** (rendezvous point) між producer і consumer. Не допускає `null`.

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-synchronousqueue|SynchronousQueue<E>]]
```

> [!NOTE]
> `SynchronousQueue` має **ємність 0**. `peek()` завжди повертає `null`. `size()` завжди повертає `0`. `isEmpty()` завжди повертає `true`.

**SynchronousQueue — TransferStack/TransferQueue, dual data structure, spin-then-park** ^java-collection-framework-synchronousqueue-transfer-impl
`SynchronousQueue` реалізує два алгоритми: `TransferStack` (unfair, LIFO) та `TransferQueue` (fair, FIFO). Обидва — **dual stack/queue**: вузол може бути або DATA (producer поклав елемент) або REQUEST (consumer чекає). Spin-then-park стратегія: потік спочатку спінується перед тим як `LockSupport.park()`. Все на CAS — немає lock.

**SynchronousQueue vs CountDownLatch/CyclicBarrier/Phaser** ^java-collection-framework-sync-primitives-vs-queue
`SynchronousQueue` — для передачі **даних** між потоками. Бар'єри лише синхронізують виконання потоків у певній точці, не передаючи об'єкти.

**Методи `SynchronousQueue`** ^java-collection-framework-synchronousqueue-big-o-notation

| Метод | Поведінка | Опис |
| :--- | :--- | :--- |
| `put(E e)` | блокує | Чекає поки не прийде `take()`. Передає елемент напряму |
| `take()` | блокує | Чекає поки не прийде `put()`. Отримує елемент напряму |
| `offer(E e)` | не блокує | Передає елемент якщо є готовий consumer. Інакше → `false` |
| `poll()` | не блокує | Забирає якщо є готовий producer. Інакше → `null` |
| `peek()` | ніколи не блокує | Завжди повертає `null` |

#### Практичні застосування

**Thread pool handoff — Executors.newCachedThreadPool()**
`SynchronousQueue` використовується всередині `Executors.newCachedThreadPool()`:
```java
new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>())
```
Це забезпечує що кожна задача негайно отримує потік — або існуючий вільний, або новостворений.

#### Підводні камені

> [!WARNING]
> `offer()` без таймауту **завжди повертає `false`** якщо в момент виклику немає потоку що очікує на `take()`. Елемент при цьому **не зберігається**.

> [!NOTE]
> `new SynchronousQueue<>(true)` — fair mode (FIFO). `new SynchronousQueue<>(false)` (default) — unfair mode (LIFO-подібний, вищий throughput).

> [!TIP]
> Використовуй `SynchronousQueue` коли потрібен **прямий handoff** між потоками без буферизації.
