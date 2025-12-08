package kovteba.example1;

import java.util.Stack;

// tag::History[]
public class History {

    private final Stack<EditorMemento> states = new Stack<>();

    public void push(EditorMemento memento) {
        states.push(memento);
    }

    public EditorMemento pop() {
        if (states.isEmpty()) {
            return null;
        }
        return states.pop();
    }
}
// end::History[]
