package kovteba.ui.impl.win;

import kovteba.ui.Button;

// tag::WindowsButton[]
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering Windows button.");
    }
}
// end::WindowsButton[]
