package kovteba;

import kovteba.factory.GUIFactory;
import kovteba.factory.impl.MacGUIFactory;
import kovteba.factory.impl.WindowsGUIFactory;
import kovteba.ui.Button;
import kovteba.ui.Checkbox;

// tag::AbstractFactoryDemo[]
public class AbstractFactoryDemo {

    public static void main(String[] args) {

        String os = System.getProperty("os.name").toLowerCase();
        GUIFactory factory = null;

        if ("mac os x".equals(os)) {
            factory = new MacGUIFactory();

        } else if ("windows".equals(os)) {
            factory = new WindowsGUIFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}
// end::AbstractFactoryDemo[]
