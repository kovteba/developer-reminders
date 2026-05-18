### LinkedBlockingQueue ^java-collection-framework-linkedblockingqueue

`LinkedBlockingQueue` у Java — це **потокобезпечна черга на основі зв'язного списку** з пакету `java.util.concurrent`, яка реалізує інтерфейс `BlockingQueue<E>`. Може бути як **обмеженою** (bounded) так і **необмеженою** (unbounded).

Головна ідея: producer і consumer використовують **два незалежних lock** — `putLock` і `takeLock`. Завдяки цьому запис і читання можуть відбуватись **одночасно**, що дає вищу пропускну здатність порівняно з `ArrayBlockingQueue`.

* `BlockingQueue<E>` — блокуючі операції `put` / `take`
* `Queue<E>` — неблокуючі операції `offer` / `poll`
* `Collection<E>` — базові операції колекції

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-linkedblockingqueue|LinkedBlockingQueue<E>]]
```

> [!NOTE]
> `LinkedBlockingQueue` знаходиться у пакеті `java.util.concurrent`. Може бути необмеженою (default capacity = `Integer.MAX_VALUE`).

> [!WARNING]
> `LinkedBlockingQueue` **не допускає `null`**. Спроба додати `null` викине `NullPointerException`.

> [!WARNING]
> При використанні **необмеженої** черги — `put` **ніколи не блокується**. Якщо producer швидший за consumer — черга росте необмежено і може спричинити `OutOfMemoryError`.

**Конструктор LinkedBlockingQueue()**
```java
LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
```

*Що робить:* створює необмежену чергу з capacity = `Integer.MAX_VALUE`.

**Конструктор LinkedBlockingQueue(int capacity)**
```java
LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(100);
```

*Що робить:* створює обмежену чергу. `put` блокується коли `count == capacity`.

**BigO notation для LinkedBlockingQueue** ^java-collection-framework-linkedblockingqueue-class-big-o-notation

| Метод | Складність | Пояснення |
| :--- | :--- | :--- |
| `put(E e)` | O(1) | Створює новий `Node`, захоплює `putLock`, додає у хвіст. Блокується на `notFull` якщо черга повна |
| `take()` | O(1) | Захоплює `takeLock`, видаляє голову. Блокується на `notEmpty` якщо черга порожня |
| `offer(E e)` | O(1) | Як `put` але повертає `false` замість блокування якщо черга повна |
| `poll()` | O(1) | Як `take` але повертає `null` замість блокування якщо черга порожня |
| `size()` | O(1) | Повертає `AtomicInteger count` — без захоплення lock |
| `drainTo(Collection c)` | O(n) | Захоплює `takeLock`, атомарно переміщує всі елементи у `c`. Ефективніше ніж n разів `poll` |

> [!NOTE]
> **Слабко консистентний (weakly consistent) ітератор** — ітератор `LinkedBlockingQueue` **не кидає** `ConcurrentModificationException`. Він гарантує що побачить всі елементи що існували на момент його створення.

**LinkedBlockingQueue — два lock, AtomicInteger, happens-before** ^java-collection-framework-linkedblockingqueue-dual-lock
`putLock` захищає запис у хвіст. `takeLock` захищає читання з голови. `AtomicInteger count` координує між ними без спільного lock. Два lock дозволяють producer і consumer працювати одночасно на різних ядрах — throughput ~2x порівняно з `ArrayBlockingQueue`.

**ThreadPoolExecutor та BlockingQueue — lifecycle задач** ^java-collection-framework-blockingqueue-threadpool
`ThreadPoolExecutor` використовує `BlockingQueue` як чергу задач. `Executors.newFixedThreadPool` і `Executors.newCachedThreadPool` всередині використовують `LinkedBlockingQueue` як чергу задач для `ThreadPoolExecutor`.

#### Внутрішній устрій — два lock і AtomicInteger
Це ключова відмінність від `ArrayBlockingQueue`:

```java
// Вузол зв'язного списку
static class Node<E> {
    E item;
    Node<E> next;
    Node(E x) { item = x; }
}

private final int capacity;
private final AtomicInteger count = new AtomicInteger(0);
transient Node<E> head; // dummy-вузол
private transient Node<E> last;

private final ReentrantLock takeLock = new ReentrantLock();
private final Condition notEmpty = takeLock.newCondition();

private final ReentrantLock putLock = new ReentrantLock();
private final Condition notFull = putLock.newCondition();
```

> [!NOTE]
> **Dummy-вузол** дозволяє `putLock` і `takeLock` **не конфліктувати**. Producer завжди пише у `last`, consumer завжди читає `head.next` — це **різні вузли**.

#### Підводні камені

> [!WARNING]
> `new LinkedBlockingQueue<>()` створює **необмежену** чергу. Для production завжди вказуй явний capacity щоб уникнути `OutOfMemoryError`.

> [!NOTE]
> При кожному виклику `put()` створюється новий `Node` об'єкт. При інтенсивному навантаженні це створює тиск на GC. Для GC-sensitive систем розглянь `ArrayBlockingQueue`.
