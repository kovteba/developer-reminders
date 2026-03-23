package kovteba.collectionframework.iterable.collection.list.stack;

import java.util.Stack;

// tag::StackPushExample1[]
public class StackPushExample1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
    }
}
// end::StackPushExample1[]

// tag::StackPushExample1Result[]
// Stack: [1, 2, 3]
// end::StackPushExample1Result[]
