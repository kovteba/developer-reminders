package kovteba.collectionframework.iterable.collection.list.vector.stack;

import java.util.Stack;

// tag::StackPeekExample1[]
public class StackPeekExample1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack: " + stack);
    }
}
// end::StackPeekExample1[]

// tag::StackPeekExample1Result[]
// Top element: 3
// Stack: [1, 2, 3]
// end::StackPeekExample1Result[]
