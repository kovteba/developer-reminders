package kovteba.collectionframework.iterable.collection.list.linkedlist;

import java.util.LinkedList;

// tag::LinkedListRemoveLastExample1[]
public class LinkedListRemoveLastExample1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        linkedList.removeLast();

        System.out.println(linkedList);
    }
}
// end::LinkedListRemoveLastExample1[]

// tag::LinkedListRemoveLastExample1Result[]
// [First, Second, Third]
// [First, Second]
// end::LinkedListRemoveLastExample1Result[]
