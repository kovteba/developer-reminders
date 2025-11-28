package kovteba.factory.impl;

import kovteba.factory.GUIFactory;
import kovteba.ui.Button;
import kovteba.ui.Checkbox;
import kovteba.ui.impl.win.WindowsButton;
import kovteba.ui.impl.win.WindowsCheckbox;

// tag::WindowsGUIFactory[]
public class WindowsGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
// end::WindowsGUIFactory[]