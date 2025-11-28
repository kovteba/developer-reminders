package kovteba.ui.impl.mac;

import kovteba.ui.Button;

// tag::MacButton[]
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering MacOS button.");
    }
}
// end::MacButton[]
