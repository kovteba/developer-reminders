##### Iterable ^java-collection-framework-iterable

Інтерфейс `Iterable<T>` найвищий рівень ієрархії. Дає можливість використовувати for-each loop.

```java
public interface Iterable<T> {
    Iterator<T> iterator();
    default void forEach(Consumer<? super T> action);
    default Spliterator<T> spliterator();
}
```

* `iterator()` — повертає Iterator для обходу елементів. forEach(action) — виконує дію для кожного елемента. Синтаксичний цукор над `iterator()`.
* `spliterator()` — повертає Spliterator для паралельного обходу (Stream API).

```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
    default void remove();
    default void forEachRemaining(Consumer<? super T> action);
}
```

* `hasNext()` — повертає true якщо є наступний елемент;
* `next()` — повертає наступний елемент і зсуває курсор. Кидає NoSuchElementException якщо елементів немає;
* `remove()` — видаляє останній елемент повернутий next(). Єдиний безпечний спосіб видалення під час ітерації. Кидає IllegalStateException якщо next() ще не викликався;
* `forEachRemaining(action)` — обробляє всі елементи що залишились.

Головні властивості:

- Може тільки один раз пройти по колекції. Для проходу в двох напрямках є [[#java-collection-frameworl-listiterator-interface|`ListIterator`]];
- Якщо в foreach циклі структурно модифікувати колекцію, при подальшому зверненні до елементу (неявно через ітератор) отримаємо `ConcurrentModificationException` (fail-fast);

`interface Iterable` має єдиний метод `iterator()`, який повертає об'єкт-ітератор (`interface Iterator`), який використовується для послідовного звертання до елементів набору даних і має методи `next()`,`hasNext()` та `remove()`. ^java-collection-framework-iterable-iterator

За допомогою методу `next()` можна отримати наступний елемент в наборі. Метод `hasNext()` дозволяє перевірити наявність наступного елемента. Тому декілька послідовних викликів цього методу не змінять позицію курсора. Ці методи слід використовувати разом при організації циклу перебору елементів колекції. ^java-collection-framework-iterator-next-has-next-10-times

Якщо викликати метод `next()` ітератора, що вказує на останній елемент в колекції, то виникне виключення `NoSuchElementException`. Слід про це пам'ятати і використовувати метод `hasNext()` перед методом `next()`. Звичайні колекції не є потокобезпечними. Тому, якщо два ітератори в різних потоках працюють з однією і тією ж колекцією, то зміна вмісту колекції в одному потоці супроводжується викликом виключення `ConcurrentModificationException` в іншому потоці при виклику ітератора одного з його методів. Щоб уникнути цього, слід використовувати потокобезпечні concurrent колекції. ^java-collection-framework-iterator-next-without-has-next

Послідовність отримання елементів колекції при переборі ітератором залежить від типу та набору елементів. Якщо використовується `ArrayList`, то ітератор починає з нульового індексу та інкрементує індекс на кожному кроці. Якщо об'єкт має тип `HashSet`, то порядок слідування елементів колекції може виявитися випадковим. При використанні Iterator'a, можна бути впевненим, що він перебере всі елементи, але порядок елементів може бути випадковим.

Метод `remove()` видаляє поточний елемент, який був отриманий при останньому виклику `next()`. Якщо метод `remove()` буде викликан після виклику методу `next()` то він видаляє елемент, інакше буде викликано виключення `IllegalStateException`. Метод `remove()` не можна викликати двічі підряд для видалення елементів. Після першого видалення слід повторно викликати метод `next()`. ^java-collection-framework-remove-method

`Iterator` - це нова версія інтерфейсу `Enumeration`. Хоча обидва інтерфейси слугують для обходу колекції але `Enumeration` вважається застарілим, хоча його методи використовуються у застарілих класах таких як `Vector` та `Stack`. `Iterator` був введений в Java 1.2. `Iterator` має більш зрозумілі назви методів, що полегшує роботу з ним (`Enumeration.hasMoreElements()` -> `Iterator.hasNext()`, `Enumeration.nextElement()` -> `Iterator.next()`). За допомогою `Enumeration` не можна додавати або видаляти елементи, тоді як `Iterator` може. ^java-collection-framework-enumeration-iterator

Колекції які реалізують інтерфейс `Iterable` можуть бути використані в циклі `for-each`, який використовує `Iterator`. ^java-collection-framework-iterable-iterator-for-each

### ListIterator ^java-collection-frameworl-listiterator-interface
`ListIterator` розширює інтерфейс `Iterator`. Головними відмінностями `ListIterator` від `Iterator` є:

- `ListIterator` може бути використаний тільки для перебору елементів колекцій `List`, тоді як `Iterator` може бути використаний для перебору елементів колекцій `Set` та `List`;
- `Iterator` дозволяє перебирати елементи тільки в одному напрямку, за допомогою методу `next()`. Тоді як `ListIterator` дозволяє перебирати список в обох напрямках, за допомогою методів `next()` та `previous()`;
- `ListIterator` не вказує на конкретний елемент: його поточна позиція розташовується між елементами, які повертають методи `previous()` та `next()`.
- За допомогою `ListIterator` ви можете модифікувати список, додаючи/видаляючи елементи за допомогою методів `add()` та `remove()`. `Iterator` не підтримує даного функціоналу.

![[collection-framework-interface-collection.md]]
