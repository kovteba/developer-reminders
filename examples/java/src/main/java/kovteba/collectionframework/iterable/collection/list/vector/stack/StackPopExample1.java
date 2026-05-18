package kovteba.collectionframework.iterable.collection.list.vector.stack;

import java.util.Stack;

// tag::StackPopExample1[]
public class StackPopExample1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack: " + stack);
    }
}
// end::StackPopExample1[]

// tag::StackPopExample1Result[]
// Popped element: 3
// Stack: [1, 2]
// end::StackPopExample1Result[]
