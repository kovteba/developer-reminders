##### Queue ^java-collection-framework-queue

**BlockingQueue — 4 сімейства методів та back-pressure** ^java-collection-framework-blockingqueue-method-families
`BlockingQueue` визначає 4 поведінки для кожної операції: (1) кидає виняток (`add`/`remove`/`element`), (2) повертає значення (`offer`/`poll`/`peek`), (3) блокує нескінченно (`put`/`take`), (4) блокує з таймаутом (`offer(e,t,u)`/`poll(t,u)`). `put()` реалізує back-pressure: producer блокується коли черга повна, змушуючи уповільнити виробництво. "Bursty traffic" (пікові навантаження): `LinkedBlockingQueue` з великою capacity буферизує пік; `SynchronousQueue` — ні (кожна задача вимагає вільного потоку).

`Queue<E>` — інтерфейс, який розширює `Collection` і визначає поведінку **однонаправленої черги**. Елементи додаються в хвіст черги і видаляються з голови, згідно принципу `FIFO` (first-in, first-out).

```text
[I] [[#java-collection-framework-queue|Queue<E>]]
├── [C] [[#java-collection-framework-priorityqueue|PriorityQueue<E>]]
├── [I] [[#java-collection-framework-deque|Deque<E>]]
│   ├── [C] [[#java-collection-framework-arraydeque|ArrayDeque<E>]]
│   ├── [C] [[#java-collection-framework-linkedlist|LinkedList<E>]]
│   └── [I] BlockingDeque<E>
│       └── [CC] [[#java-collection-framework-linkedblockingqueue|LinkedBlockingDeque<E>]]
│
└── [I] BlockingQueue<E>
    ├── [CC] [[#java-collection-framework-arrayblockingqueue|ArrayBlockingQueue<E>]]
    ├── [CC] [[#java-collection-framework-linkedblockingqueue|LinkedBlockingQueue<E>]]
    ├── [CC] PriorityBlockingQueue<E>
    ├── [CC] DelayQueue<E>
    ├── [CC] SynchronousQueue<E>
    └── [I] TransferQueue<E>
        └── [CC] LinkedTransferQueue<E>
```

**Методи інтерфейсу `Queue`** ^java-collection-framework-queue-interface-methods

Інтерфейс `Queue` надає дві групи методів — ті що кидають виняток при помилці і ті що повертають спеціальне значення:

| Операція | Кидає виняток | Повертає значення |
| :--- | :--- | :--- |
| Вставка | `add(E e)` → `IllegalStateException` | `offer(E e)` → `false` |
| Видалення | `remove()` → `NoSuchElementException` | `poll()` → `null` |
| Перегляд | `element()` → `NoSuchElementException` | `peek()` → `null` |

**Опис методів:**
* `boolean add(E e)` — додає елемент у хвіст черги. Якщо черга обмежена і заповнена — кидає `IllegalStateException`;
* `boolean offer(E e)` — додає елемент у хвіст черги. Якщо черга заповнена — повертає `false` (замість виключення). Рекомендований метод для обмежених черг;
* `E remove()` — видаляє і повертає елемент з голови черги. Якщо черга порожня — кидає `NoSuchElementException`;
* `E poll()` — видаляє і повертає елемент з голови черги. Якщо черга порожня — повертає `null`;
* `E element()` — повертає (але не видаляє) елемент з голови черги. Якщо черга порожня — кидає `NoSuchElementException`;
* `E peek()` — повертає (але не видаляє) елемент з голови черги. Якщо черга порожня — повертає `null`.

> [!TIP]
> Надавай перевагу методам що повертають значення (`offer`, `poll`, `peek`) над тими що кидають виняток (`add`, `remove`, `element`), якщо порожня/заповнена черга є очікуваним станом, а не помилкою.

![[priorityqueue/collection-framework-class-priorityqueue.md]]
![[deque/collection-framework-interface-deque.md]]
![[blockingqueue/arrayblockingqueue/collection-framework-class-arrayblockingqueue.md]]
![[blockingqueue/linkedblockingqueue/collection-framework-class-linkedblockingqueue.md]]
![[blockingqueue/priorityblockingqueue/collection-framework-class-priorityblockingqueue.md]]
![[blockingqueue/delayqueue/collection-framework-class-delayqueue.md]]
![[blockingqueue/synchronousqueue/collection-framework-class-synchronousqueue.md]]
![[blockingqueue/linkedtransferqueue/collection-framework-class-linkedtransferqueue.md]]
