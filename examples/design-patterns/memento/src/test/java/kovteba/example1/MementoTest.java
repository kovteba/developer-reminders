package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MementoTest {

    @Test
    void editor_saveAndRestore_recoversState() {
        Editor editor = new Editor();
        editor.setText("Hello");
        editor.setCursorPosition("0:5");
        editor.setFontSize(12);

        EditorMemento saved = editor.save();

        editor.setText("Changed");
        editor.setCursorPosition("1:3");
        editor.setFontSize(16);

        editor.restore(saved);
        String restored = editor.toString();

        assertTrue(restored.contains("Hello"));
        assertTrue(restored.contains("0:5"));
        assertTrue(restored.contains("12"));
    }

    @Test
    void memento_storesCorrectValues() {
        EditorMemento m = new EditorMemento("text", "pos", 14);
        assertEquals("text", m.getText());
        assertEquals("pos", m.getCursorPosition());
        assertEquals(14, m.getFontSize());
    }

    @Test
    void history_pushAndPop_returnsLastSaved() {
        History history = new History();
        EditorMemento m1 = new EditorMemento("v1", "0", 10);
        EditorMemento m2 = new EditorMemento("v2", "1", 11);

        history.push(m1);
        history.push(m2);

        assertSame(m2, history.pop());
        assertSame(m1, history.pop());
    }

    @Test
    void history_popFromEmpty_returnsNull() {
        History history = new History();
        assertNull(history.pop());
    }

    @Test
    void history_multipleUndos_restoreCorrectly() {
        Editor editor = new Editor();
        History history = new History();

        editor.setText("v1");
        editor.setFontSize(10);
        history.push(editor.save());

        editor.setText("v2");
        editor.setFontSize(12);
        history.push(editor.save());

        editor.setText("v3");
        editor.setFontSize(14);

        editor.restore(history.pop());
        assertTrue(editor.toString().contains("v2"));

        editor.restore(history.pop());
        assertTrue(editor.toString().contains("v1"));
    }
}
