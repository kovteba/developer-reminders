##### PriorityQueue ^java-collection-framework-priorityqueue

`PriorityQueue` у Java — це **черга з пріоритетом**, яка реалізує інтерфейс `Queue<E>`. На відміну від звичайної черги (FIFO), елементи видаляються **у порядку пріоритету** — найменший елемент (за натуральним порядком або `Comparator`) завжди на вершині.

* `Queue<E>` — поведінка черги: `offer`, `poll`, `peek`
* `Iterable<E>` — підтримка `for-each`
* `Collection<E>` — базові операції колекції

**Ієрархія наслідування**
```text
Object
  └── AbstractCollection<E>
        └── AbstractQueue<E>
              └── [[#java-collection-framework-priorityqueue|PriorityQueue<E>]]
```

> [!WARNING]
> `PriorityQueue` **не є потокобезпечною**. Для багатопотокового середовища використовуй `PriorityBlockingQueue` з пакету `java.util.concurrent`.

> [!WARNING]
> `PriorityQueue` **не допускає `null`**. Спроба додати `null` викине `NullPointerException`, оскільки порівняння `null` з іншими елементами неможливе.

**Конструктор PriorityQueue()**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

*Що робить:* створює порожню чергу з початковою ємністю 11 і натуральним порядком (`Comparable`). Елементи мають реалізовувати `Comparable`, інакше — `ClassCastException` при додаванні другого елемента.

**Конструктор PriorityQueue(int initialCapacity)**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(100);
```

**Конструктор PriorityQueue(Comparator<? super E> comparator)**
```java
PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length));
```

**Конструктор PriorityQueue(Collection<? extends E> c)**
```java
List<Integer> source = List.of(5, 1, 3, 2, 4);
PriorityQueue<Integer> pq = new PriorityQueue<>(source);
```

*Що робить:* копіює всі елементи колекції та виконує **heapify** — побудову купи за O(n). Це швидше, ніж додавати елементи по одному (що було б O(n log n)).

**BigO notation для PriorityQueue** ^java-collection-framework-priorityqueue-class-big-o-notation

| Метод | Складність | Пояснення |
| :--- | :--- | :--- |
| [[#java-collection-framework-priorityqueue-offer|`offer(E e)`]] | O(log n) | Додає елемент в кінець масиву, потім **sift up** — піднімає елемент вгору по купі до правильної позиції |
| `add(E e)` | O(log n) | Псевдонім `offer`, але кидає `IllegalStateException` якщо не вдалось додати |
| `peek()` | O(1) | Повертає `queue[0]` — корінь купи — без видалення. Завжди мінімальний елемент |
| [[#java-collection-framework-priorityqueue-poll|`poll()`]] | O(log n) | Видаляє і повертає корінь (`queue[0]`), переміщує останній елемент на вершину, потім **sift down** — опускає його до правильної позиції |
| `remove()` | O(log n) | Як `poll()`, але кидає `NoSuchElementException` якщо черга порожня |
| `remove(Object o)` | O(n) | Лінійний пошук елемента (O(n)) + видалення з відновленням властивості купи (O(log n)) |
| `contains(Object o)` | O(n) | Лінійний перебір внутрішнього масиву з `equals()` — купа не гарантує порядок за значенням |
| `size()` | O(1) | Повертає поле `size` — лічильник елементів |
| `isEmpty()` | O(1) | Перевіряє `size == 0` |
| `clear()` | O(n) | Обнуляє всі елементи масиву (`queue[i] = null`) щоб GC міг зібрати об'єкти, потім `size = 0` |
| `toArray()` | O(n) | Копіює внутрішній масив через `Arrays.copyOf`. **Масив не відсортований** — лише купа-порядок |
| `iterator()` | O(1) | Створює ітератор. **Не гарантує порядок пріоритету** — ітерує по внутрішньому масиві як є |

**Heap на масиві — формула, d-ary heap, memory layout** ^java-collection-framework-priorityqueue-heap-formula
Для вузла з індексом `i`: батько `(i-1)/2`, лівий нащадок `2*i+1`, правий `2*i+2`. Java використовує binary heap (d=2) бо він оптимальний для більшості випадків. Memory layout масиву є cache-friendly для батько-нащадок доступу (сусідні індекси). `peek()` — O(1) бо мінімум завжди `queue[0]`.

**Sift-up (swim) — відновлення heap після add()** ^java-collection-framework-priorityqueue-sift-up
Новий елемент додається в `queue[size]` (кінець масиву), потім `siftUp(size, element)`: поки `k > 0` і елемент менший за батька → елемент і батько міняються місцями, `k = parent`. Максимум `log n` порівнянь і обмінів.

**Sift-down (sink) — відновлення heap після poll()** ^java-collection-framework-priorityqueue-sift-down
`poll()` зберігає `queue[0]`, ставить `queue[size-1]` на вершину, обнуляє `queue[size-1]`, потім `siftDown(0, lastElement)`: вибирає меншого з двох нащадків, якщо він менший за поточний — міняється, продовжує вниз. Максимум `log n` кроків.

**Heapify — O(n) побудова купи з колекції** ^java-collection-framework-priorityqueue-heapify
`heapify()` у конструкторі: від `(n/2)-1` до `0` викликає `siftDown(i, queue[i])`. Складність O(n) (не O(n log n)) бо більшість вузлів — листя (не потребують sift), а глибокий sift потрібен лише ~n/4 вузлам.

**PriorityQueue.remove(Object o) — чому O(n)** ^java-collection-framework-priorityqueue-remove-object
`remove(Object o)` спочатку лінійно шукає об'єкт у `queue[0..size-1]` через `equals()` — O(n). Після знаходження на позиції `i`: ставить `queue[size-1]` на позицію `i`, потім виконує і `siftUp` і `siftDown` щоб відновити heap.

**Max-heap через Comparator.reverseOrder()** ^java-collection-framework-priorityqueue-max-heap
`new PriorityQueue<>(Comparator.reverseOrder())`. У max-heap `queue[0]` — максимальний елемент.

**K-way merge та алгоритм Dijkstra** ^java-collection-framework-priorityqueue-kway-merge
K-way merge: PriorityQueue зберігає (value, listIndex, elementIndex) для кожного з K списків. `poll()` дає глобальний мінімум → O(n log K). Dijkstra: `PriorityQueue<int[]>` де `int[]{distance, node}` — O((V+E) log V).

#### Внутрішній устрій — бінарна мінімальна купа
`PriorityQueue` всередині — це **бінарна мінімальна купа** (binary min-heap), реалізована на масиві:

```java
transient Object[] queue; // внутрішній масив-купа
private int size;         // кількість елементів
private final Comparator<? super E> comparator; // null = натуральний порядок
```

Купа — це повне бінарне дерево, збережене в масиві. Для вузла з індексом `i`:
* батько: `(i - 1) / 2`
* лівий нащадок: `2 * i + 1`
* правий нащадок: `2 * i + 2`

**offer(E e) — sift up** ^java-collection-framework-priorityqueue-offer
```java
private void siftUp(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0) break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}
```

**poll() — sift down** ^java-collection-framework-priorityqueue-poll
```java
private void siftDown(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size && compare(c, queue[right]) > 0)
            c = queue[child = right];
        if (compare(x, c) <= 0) break;
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}
```

#### Підводні камені

> [!WARNING]
> `PriorityQueue` не є FIFO-структурою для елементів з однаковим пріоритетом. Порядок між рівнозначними елементами визначається внутрішньою структурою heap і є непередбачуваним.

> [!WARNING]
> `iterator()` і цикл `for-each` ітерують по внутрішньому масиву-heap у **довільному** порядку — НЕ у порядку пріоритету. Для отримання елементів у порядку пріоритету використовуй виключно `poll()`.

> [!WARNING]
> `PriorityQueue` **не допускає `null`**. Порівняння `null` з іншими елементами через `Comparator` або `Comparable` неможливе і одразу кидає `NullPointerException`.
