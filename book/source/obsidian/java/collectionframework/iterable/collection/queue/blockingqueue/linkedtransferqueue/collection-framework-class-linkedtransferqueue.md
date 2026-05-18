### LinkedTransferQueue ^java-collection-framework-linkedtransferqueue

`LinkedTransferQueue<E>` — це **необмежена потокобезпечна черга** з пакету `java.util.concurrent`, яка реалізує інтерфейс `TransferQueue<E>`. Розширює можливості `LinkedBlockingQueue` додаючи метод `transfer()` — **синхронна передача** елементу напряму consumer-у. Lock-free реалізація на базі CAS.

* `TransferQueue<E>` → `BlockingQueue<E>` — додаткові методи transfer
* `Queue<E>`, `Collection<E>`, `Iterable<E>`, `Serializable`

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-linkedtransferqueue|LinkedTransferQueue<E>]]
```

**TransferQueue інтерфейс — додаткові методи** ^java-collection-framework-transferqueue-interface
`TransferQueue` розширює `BlockingQueue`:
* `transfer(e)` — синхронна передача (блокує поки consumer не отримає);
* `tryTransfer(e)` — non-blocking (false якщо немає waiting consumer);
* `hasWaitingConsumer()` — O(1) перевірка наявності REQUEST вузлів.

**LinkedTransferQueue.transfer() — QNode, slack, direct handoff vs buffering** ^java-collection-framework-linkedtransferqueue-transfer-impl
Внутрішній `QNode` може бути DATA або REQUEST. **Slack** — оптимізація: не оновлює `head`/`tail` при кожній операції (lazy pointer updates), що зменшує кількість CAS операцій у ~2x при високому навантаженні.

**BigO notation для `LinkedTransferQueue`** ^java-collection-framework-linkedtransferqueue-big-o-notation

| Метод | Складність | Пояснення |
| :--- | :--- | :--- |
| `put(E e)` | O(1) | Прямий handoff якщо є consumer, або вставка DATA вузла в хвіст |
| `transfer(E e)` | O(1)* | Прямий handoff (O(1)). Блокує якщо немає consumer — чекає REQUEST вузла |
| `take()` | O(1)* | Прямий handoff від DATA вузла або блокує (REQUEST вузол) |
| `size()` | O(n) | Підраховує лише DATA вузли — O(n) прохід |
| `hasWaitingConsumer()` | O(1) | Перевіряє чи є REQUEST вузли |

#### Внутрішній устрій — Dual Queue
`LinkedTransferQueue` реалізує **Dual Queue**:
* Тип вузла 1: **DATA node** — producer поклав елемент і чекає consumer.
* Тип вузла 2: **REQUEST node** — consumer чекає елемент від producer.

**offer vs transfer:**
* `offer()` — як `LinkedBlockingQueue.put()`: якщо немає споживача, просто кладе в чергу.
* `transfer()` — **чекає** поки consumer РЕАЛЬНО отримає елемент.

#### Практичні застосування

**Підтвердження доставки (Delivery Acknowledgement)**
Producer знає що consumer РЕАЛЬНО отримав запит перед тим як продовжити.

**Publish-Subscribe з гарантованою доставкою**
Метод `transfer()` — унікальна можливість знати що consumer реально взяв елемент.

#### Підводні камені

> [!WARNING]
> `tryTransfer()` без таймауту при невдачі **не додає елемент у буфер** — він просто повертає `false`.

> [!WARNING]
> `size()` у `LinkedTransferQueue` є **O(n)** — обходить весь зв'язний список. Уникай частих викликів у hot-path коді.

> [!TIP]
> Комбінація `hasWaitingConsumer()` + `transfer()` або `put()` дозволяє будувати адаптивні producer стратегії.
