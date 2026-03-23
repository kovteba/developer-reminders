package kovteba.collectionframework.iterable.collection.list.linkedlist;

import java.util.LinkedList;

// tag::LinkedListRemoveAllExample1[]
public class LinkedListRemoveAllExample1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        linkedList.removeAll(linkedList);

        System.out.println(linkedList);
    }
}
// end::LinkedListRemoveAllExample1[]

// tag::LinkedListRemoveAllExample1Result[]
// [First, Second, Third]
// []
// end::LinkedListRemoveAllExample1Result[]
