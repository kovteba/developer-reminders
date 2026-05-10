### ArrayBlockingQueue ^java-collection-framework-arrayblockingqueue

`ArrayBlockingQueue` у Java — це **потокобезпечна обмежена черга** (bounded blocking queue) з пакету `java.util.concurrent`, побудована на масиві фіксованого розміру. Реалізує інтерфейс `BlockingQueue<E>`.

Головна ідея: якщо черга **заповнена** — потік-письменник **блокується** до появи місця. Якщо черга **порожня** — потік-читач **блокується** до появи елемента.

* `BlockingQueue<E>` — блокуючі операції `put` / `take`
* `Queue<E>` — неблокуючі операції `offer` / `poll`
* `Collection<E>` — базові операції колекції

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-arrayblockingqueue|ArrayBlockingQueue<E>]]
```

> [!NOTE]
> `ArrayBlockingQueue` знаходиться у пакеті `java.util.concurrent`. На відміну від `LinkedBlockingQueue` — має **фіксований** розмір, заданий при створенні. Динамічне розширення неможливе.

> [!WARNING]
> `ArrayBlockingQueue` **не допускає `null`**. Спроба додати `null` викине `NullPointerException`, оскільки `null` повертається як сигнал порожньої черги у неблокуючих методах (`poll`, `peek`).

**Конструктор ArrayBlockingQueue(int capacity)**
```java
ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
```

**Конструктор ArrayBlockingQueue(int capacity, boolean fair)**
```java
ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10, true);
```

*Що робить:* створює чергу з **fair** (справедливим) режимом. При `fair=true` — потоки що чекають на `put`/`take` обслуговуються у порядку FIFO. Реалізується через `ReentrantLock(true)`.

**BigO notation для ArrayBlockingQueue** ^java-collection-framework-arrayblockingqueue-class-big-o-notation

| Метод | Складність | Пояснення |
| :--- | :--- | :--- |
| `put(E e)` | O(1) | Записує елемент на позицію `putIndex` у масиві. Якщо черга повна — блокує потік на `Condition notFull` до появи місця |
| `take()` | O(1) | Читає елемент з позиції `takeIndex`. Якщо черга порожня — блокує потік на `Condition notEmpty` до появи елемента |
| `offer(E e)` | O(1) | Як `put`, але повертає `false` замість блокування якщо черга повна |
| `poll()` | O(1) | Як `take`, але повертає `null` замість блокування якщо черга порожня |
| `size()` | O(1) | Повертає поле `count` — лічильник елементів під lock |
| `drainTo(Collection c)` | O(n) | Атомарно переміщує всі елементи у колекцію `c` під lock. Ефективніше ніж n разів `poll` |

**ArrayBlockingQueue — ReentrantLock, Condition, await/signal** ^java-collection-framework-arrayblockingqueue-lock-condition
`ArrayBlockingQueue` використовує один `ReentrantLock lock` і два `Condition`: `notFull` (producer чекає місця) та `notEmpty` (consumer чекає елемента). `put()`: захоплює lock → `while(count==length) notFull.await()` → `enqueue(e)` → `notEmpty.signal()`.

**AQS — AbstractQueuedSynchronizer, основа ReentrantLock** ^java-collection-framework-blockingqueue-aqs
AQS — базовий клас для синхронізаторів у `java.util.concurrent`. Зберігає `volatile int state` і CLH-queue очікуючих потоків. `ReentrantLock` використовує AQS для керування доступом та чергою очікування.

**ArrayBlockingQueue — кільцевий буфер (putIndex, takeIndex)** ^java-collection-framework-arrayblockingqueue-circular
`items[putIndex]` — місце запису, `items[takeIndex]` — місце читання. Після кожного запису: `if (++putIndex == items.length) putIndex = 0`. Аналогічно для `takeIndex`.

#### Внутрішній устрій
`ArrayBlockingQueue` використовує **один ReentrantLock** і **два Condition** об'єкти:

```java
final Object[] items;           // масив фіксованого розміру
int takeIndex;                  // індекс наступного елемента для читання
int putIndex;                   // індекс наступної позиції для запису
int count;                      // кількість елементів у черзі

final ReentrantLock lock;       // один lock для читачів і письменників
private final Condition notEmpty; // сигнал: з'явився елемент → розбудити читача
private final Condition notFull;  // сигнал: з'явилось місце → розбудити письменника
```

> [!NOTE]
> На відміну від `LinkedBlockingQueue`, `ArrayBlockingQueue` використовує **один спільний lock** для `put` і `take`. Це означає що producer і consumer **не можуть працювати одночасно**.

#### Підводні камені

> [!WARNING]
> Виклик `put()` і `take()` в **одному й тому самому потоці** при повній черзі призведе до deadlock.

> [!NOTE]
> `fair=true` гарантує FIFO між потоками, але знижує throughput через додаткові витрати на підтримку порядку. Запобігає **thread starvation**.

> [!TIP]
> Використовуй `drainTo(collection, maxElements)` для **batch processing** — один захват lock замість N окремих викликів `poll()`.
