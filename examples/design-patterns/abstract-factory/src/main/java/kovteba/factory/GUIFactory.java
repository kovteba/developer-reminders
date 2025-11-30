package kovteba.factory;

import kovteba.ui.Button;
import kovteba.ui.Checkbox;

// tag::GUIFactory[]
public interface GUIFactory {

    Button createButton();
    Checkbox createCheckbox();
}
// end::GUIFactory[]
