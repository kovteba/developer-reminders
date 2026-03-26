package kovteba;

import kovteba.factory.GUIFactory;
import kovteba.factory.impl.MacGUIFactory;
import kovteba.factory.impl.WindowsGUIFactory;
import kovteba.ui.Button;
import kovteba.ui.Checkbox;
import kovteba.ui.impl.mac.MacButton;
import kovteba.ui.impl.mac.MacCheckbox;
import kovteba.ui.impl.win.WindowsButton;
import kovteba.ui.impl.win.WindowsCheckbox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void macFactory_createsMaxButton() {
        GUIFactory factory = new MacGUIFactory();
        Button button = factory.createButton();
        assertInstanceOf(MacButton.class, button);
    }

    @Test
    void macFactory_createsMacCheckbox() {
        GUIFactory factory = new MacGUIFactory();
        Checkbox checkbox = factory.createCheckbox();
        assertInstanceOf(MacCheckbox.class, checkbox);
    }

    @Test
    void windowsFactory_createsWindowsButton() {
        GUIFactory factory = new WindowsGUIFactory();
        Button button = factory.createButton();
        assertInstanceOf(WindowsButton.class, button);
    }

    @Test
    void windowsFactory_createsWindowsCheckbox() {
        GUIFactory factory = new WindowsGUIFactory();
        Checkbox checkbox = factory.createCheckbox();
        assertInstanceOf(WindowsCheckbox.class, checkbox);
    }

    @Test
    void macButton_paint_doesNotThrow() {
        Button b = new MacButton();
        assertDoesNotThrow(b::paint);
    }

    @Test
    void macCheckbox_paint_doesNotThrow() {
        Checkbox c = new MacCheckbox();
        assertDoesNotThrow(c::paint);
    }

    @Test
    void windowsButton_paint_doesNotThrow() {
        Button b = new WindowsButton();
        assertDoesNotThrow(b::paint);
    }

    @Test
    void windowsCheckbox_paint_doesNotThrow() {
        Checkbox c = new WindowsCheckbox();
        assertDoesNotThrow(c::paint);
    }
}
