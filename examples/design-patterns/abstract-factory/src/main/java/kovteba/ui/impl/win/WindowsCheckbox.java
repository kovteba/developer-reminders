package kovteba.ui.impl.win;

import kovteba.ui.Checkbox;

// tag::WindowsCheckbox[]
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering Windows checkbox.");
    }
}
// end::WindowsCheckbox[]
