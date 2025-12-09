package kovteba.example1;

// tag::FileElement[]
public class FileElement implements FileSystemElement {

    private final String name;
    private final int size;

    public FileElement(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
// end::FileElement[]
