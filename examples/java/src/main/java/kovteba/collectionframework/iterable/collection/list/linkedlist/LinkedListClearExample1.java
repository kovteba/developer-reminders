package kovteba.collectionframework.iterable.collection.list.linkedlist;

import java.util.LinkedList;

// tag::LinkedListClearExample1[]
public class LinkedListClearExample1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        linkedList.clear();

        System.out.println(linkedList);
    }
}
// end::LinkedListClearExample1[]

// tag::LinkedListClearExample1Result[]
// [First, Second, Third]
// []
// end::LinkedListClearExample1Result[]
