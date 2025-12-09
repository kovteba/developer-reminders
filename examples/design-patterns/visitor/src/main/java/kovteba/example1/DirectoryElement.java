package kovteba.example1;

import java.util.ArrayList;
import java.util.List;

// tag::DirectoryElement[]
public class DirectoryElement implements FileSystemElement {

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public DirectoryElement(String name) {
        this.name = name;
    }

    public void add(FileSystemElement element) {
        children.add(element);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getChildren() {
        return children;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
// end::DirectoryElement[]
