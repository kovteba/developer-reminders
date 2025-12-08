package kovteba.example1;

// tag::Editor[]
public class Editor {

    private String text;
    private String cursorPosition;
    private int fontSize;

    public void setText(String text) {
        this.text = text;
    }

    public void setCursorPosition(String cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public EditorMemento save() {
        return new EditorMemento(text, cursorPosition, fontSize);
    }

    public void restore(EditorMemento memento) {
        this.text = memento.getText();
        this.cursorPosition = memento.getCursorPosition();
        this.fontSize = memento.getFontSize();
    }

    @Override
    public String toString() {
        return "Editor{" +
                "text='" + text + '\'' +
                ", cursorPosition='" + cursorPosition + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
// end::Editor[]
