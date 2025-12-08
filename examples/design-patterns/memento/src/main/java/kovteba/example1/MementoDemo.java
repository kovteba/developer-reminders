package kovteba.example1;

// tag::MementoDemo[]
public class MementoDemo {

    public static void main(String[] args) {

        Editor editor = new Editor();
        History history = new History();

        editor.setText("Hello");
        editor.setCursorPosition("0:5");
        editor.setFontSize(12);
        history.push(editor.save());
        System.out.println("State 1: " + editor);

        editor.setText("Hello World!");
        editor.setCursorPosition("0:12");
        editor.setFontSize(16);
        history.push(editor.save());
        System.out.println("State 2: " + editor);

        // Undo
        editor.restore(history.pop());
        System.out.println("Undo 1 → " + editor);

        editor.restore(history.pop());
        System.out.println("Undo 2 → " + editor);
    }
}
// end::MementoDemo[]
/*
// tag::MementoDemoResult[]
State 1: Editor{text='Hello', cursorPosition='0:5', fontSize=12}
State 2: Editor{text='Hello World!', cursorPosition='0:12', fontSize=16}
Undo 1 → Editor{text='Hello World!', cursorPosition='0:12', fontSize=16}
Undo 2 → Editor{text='Hello', cursorPosition='0:5', fontSize=12}
// end::MementoDemoResult[]
 */
