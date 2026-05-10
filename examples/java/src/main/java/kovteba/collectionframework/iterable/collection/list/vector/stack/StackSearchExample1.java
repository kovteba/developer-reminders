package kovteba.collectionframework.iterable.collection.list.vector.stack;

import java.util.Stack;

// tag::StackSearchExample1[]
public class StackSearchExample1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Element 2 found at position: " + stack.search(2));
    }
}
// end::StackSearchExample1[]

// tag::StackSearchExample1Result[]
// Element 2 found at position: 2
// end::StackSearchExample1Result[]
