package kovteba.collectionframework.iterable.collection.list.stack;

import java.util.Stack;

// tag::StackEmptyExample1[]
public class StackEmptyExample1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Is stack empty? " + stack.empty());
    }
}
// end::StackEmptyExample1[]

// tag::StackEmptyExample1Result[]
// Is stack empty? true
// end::StackEmptyExample1Result[]
