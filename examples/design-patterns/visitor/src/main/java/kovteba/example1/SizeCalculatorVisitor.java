package kovteba.example1;

// tag::SizeCalculatorVisitor[]
public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(FileElement file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(DirectoryElement directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }
}
// end::SizeCalculatorVisitor[]
