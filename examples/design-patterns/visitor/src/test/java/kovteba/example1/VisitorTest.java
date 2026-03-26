package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

    @Test
    void sizeCalculator_singleFile_returnsFileSize() {
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        FileElement file = new FileElement("readme.txt", 100);
        file.accept(visitor);
        assertEquals(100, visitor.getTotalSize());
    }

    @Test
    void sizeCalculator_multipleFiles_returnsTotalSize() {
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        FileElement f1 = new FileElement("a.txt", 200);
        FileElement f2 = new FileElement("b.txt", 300);
        f1.accept(visitor);
        f2.accept(visitor);
        assertEquals(500, visitor.getTotalSize());
    }

    @Test
    void sizeCalculator_directoryWithFiles_returnsTotalSize() {
        DirectoryElement dir = new DirectoryElement("src");
        dir.add(new FileElement("Main.java", 400));
        dir.add(new FileElement("Utils.java", 600));

        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        dir.accept(visitor);

        assertEquals(1000, visitor.getTotalSize());
    }

    @Test
    void sizeCalculator_nestedDirectories_returnsTotalSize() {
        DirectoryElement root = new DirectoryElement("root");
        DirectoryElement sub = new DirectoryElement("sub");
        sub.add(new FileElement("a.txt", 50));
        sub.add(new FileElement("b.txt", 150));
        root.add(sub);
        root.add(new FileElement("c.txt", 300));

        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        root.accept(visitor);

        assertEquals(500, visitor.getTotalSize());
    }

    @Test
    void sizeCalculator_emptyDirectory_returnsZero() {
        DirectoryElement dir = new DirectoryElement("empty");
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        dir.accept(visitor);
        assertEquals(0, visitor.getTotalSize());
    }

    @Test
    void fileElement_getName_returnsCorrectName() {
        FileElement file = new FileElement("test.txt", 10);
        assertEquals("test.txt", file.getName());
    }

    @Test
    void fileElement_getSize_returnsCorrectSize() {
        FileElement file = new FileElement("data.bin", 512);
        assertEquals(512, file.getSize());
    }

    @Test
    void directoryElement_getName_returnsCorrectName() {
        DirectoryElement dir = new DirectoryElement("mydir");
        assertEquals("mydir", dir.getName());
    }
}
