package kovteba.example1;

// tag::DirectoryComponent[]
import java.util.ArrayList;
import java.util.List;

/**
 * DirectoryComponent — композит (папка).
 * Може містити як файли, так і інші папки.
 */
public class DirectoryComponent implements Component {

    private final String name;
    private final List<Component> children = new ArrayList<>();

    public DirectoryComponent(String name) {
        this.name = name;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void showInfo() {
        System.out.println("Directory: " + name);
        for (Component c : children) {
            System.out.print("  ");
            c.showInfo();
        }
    }
}
// end::DirectoryComponent[]
