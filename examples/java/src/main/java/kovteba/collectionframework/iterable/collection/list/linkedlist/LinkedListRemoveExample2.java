package kovteba.collectionframework.iterable.collection.list.linkedlist;

import java.util.LinkedList;

// tag::LinkedListRemoveExample2[]
public class LinkedListRemoveExample2 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        linkedList.remove(1);

        System.out.println(linkedList);
    }
}
// end::LinkedListRemoveExample2[]

// tag::LinkedListRemoveExample2Result[]
// [First, Second, Third]
// [First, Third]
// end::LinkedListRemoveExample2Result[]
