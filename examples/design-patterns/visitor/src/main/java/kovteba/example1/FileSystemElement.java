package kovteba.example1;

// tag::FileSystemElement[]
public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
// end::FileSystemElement[]
