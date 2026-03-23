package kovteba.collectionframework.iterable.collection.list.linkedlist;
import java.util.LinkedList;

// tag::LinkedListRemoveFirstExample1[]
public class LinkedListRemoveFirstExample1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        System.out.println(linkedList);

        linkedList.removeFirst();

        System.out.println(linkedList);
    }
}
// end::LinkedListRemoveFirstExample1[]

// tag::LinkedListRemoveFirstExample1Result[]
// [First, Second, Third]
// [Second, Third]
// end::LinkedListRemoveFirstExample1Result[]
