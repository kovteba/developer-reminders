package kovteba.factory.impl;


import kovteba.factory.GUIFactory;
import kovteba.ui.Button;
import kovteba.ui.Checkbox;
import kovteba.ui.impl.mac.MacButton;
import kovteba.ui.impl.mac.MacCheckbox;

// tag::MacGUIFactory[]
public class MacGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
// end::MacGUIFactory[]
