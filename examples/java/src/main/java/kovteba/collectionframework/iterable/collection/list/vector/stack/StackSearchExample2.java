package kovteba.collectionframework.iterable.collection.list.vector.stack;

import java.util.Stack;

// tag::StackSearchExample2[]
public class StackSearchExample2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Element 5 found at position: " + stack.search(5));
    }
}
// end::StackSearchExample2[]

// tag::StackSearchExample2Result[]
// Element 5 found at position: -1
// end::StackSearchExample2Result[]
