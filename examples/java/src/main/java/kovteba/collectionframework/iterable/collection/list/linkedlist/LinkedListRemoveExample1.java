package kovteba.collectionframework.iterable.collection.list.linkedlist;

import java.util.LinkedList;

// tag::LinkedListRemoveExample1[]
public class LinkedListRemoveExample1 {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        linkedList.remove("Second");

        System.out.println(linkedList);
    }
}
// end::LinkedListRemoveExample1[]
// tag::LinkedListRemoveExample1Result[]
// [First, Second, Third]
// [First, Third]
// end::LinkedListRemoveExample1Result[]


