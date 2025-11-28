package kovteba.ui.impl.mac;

import kovteba.ui.Checkbox;

// tag::MacCheckbox[]
public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering MacOS checkbox.");
    }
}
// end::MacCheckbox[]
