package kovteba.collectionframework.iterable.collection.list.linkedlist;

import java.util.LinkedList;

// tag::LinkedListGetExample1[]
public class LinkedListGetExample1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
    }
}
// end::LinkedListGetExample1[]

// tag::LinkedListGetExample1Result[]
// [First, Second, Third]
// Second
// end::LinkedListGetExample1Result[]
