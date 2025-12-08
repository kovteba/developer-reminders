package kovteba.example1;

// tag::EditorMemento[]
public class EditorMemento {

    private final String text;
    private final String cursorPosition;
    private final int fontSize;

    public EditorMemento(String text, String cursorPosition, int fontSize) {
        this.text = text;
        this.cursorPosition = cursorPosition;
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public String getCursorPosition() {
        return cursorPosition;
    }

    public int getFontSize() {
        return fontSize;
    }
}
// end::EditorMemento[]
