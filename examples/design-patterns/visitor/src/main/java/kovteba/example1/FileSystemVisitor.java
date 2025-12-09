package kovteba.example1;

// tag::FileSystemVisitor[]
public interface FileSystemVisitor {
    void visit(FileElement file);
    void visit(DirectoryElement directory);
}
// end::FileSystemVisitor[]
