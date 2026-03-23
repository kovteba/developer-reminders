package kovteba.collectionframework.iterable.collection.list.arraylist;

import java.util.*;

public class ArrayListDemo1 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Java");

        String s = list.getFirst();
        list.getLast();

        list.trimToSize();
        list.ensureCapacity(1);

        Iterator o;
                Iterable e;
        Collection collection;
        List list1;

        LinkedList p;
        List<String>  l1 = new LinkedList<>();  // використовуємо як List
        Queue<String> l2 = new LinkedList<>();  // використовуємо як Queue
        Deque<String> l3 = new LinkedList<>();  // використовуємо як Deque

    }
}
