package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeTest {

    @Test
    void fileComponent_showInfo_doesNotThrow() {
        FileComponent file = new FileComponent("readme.txt");
        assertDoesNotThrow(file::showInfo);
    }

    @Test
    void directoryComponent_emptyDirectory_showInfo_doesNotThrow() {
        DirectoryComponent dir = new DirectoryComponent("src");
        assertDoesNotThrow(dir::showInfo);
    }

    @Test
    void directoryComponent_withChildren_showInfo_doesNotThrow() {
        DirectoryComponent dir = new DirectoryComponent("root");
        dir.add(new FileComponent("a.txt"));
        dir.add(new FileComponent("b.txt"));
        assertDoesNotThrow(dir::showInfo);
    }

    @Test
    void directoryComponent_nestedDirectories_showInfo_doesNotThrow() {
        DirectoryComponent root = new DirectoryComponent("root");
        DirectoryComponent sub = new DirectoryComponent("sub");
        sub.add(new FileComponent("c.txt"));
        root.add(sub);
        root.add(new FileComponent("d.txt"));
        assertDoesNotThrow(root::showInfo);
    }

    @Test
    void directoryComponent_addThenRemove_showInfo_doesNotThrow() {
        DirectoryComponent dir = new DirectoryComponent("dir");
        FileComponent file = new FileComponent("temp.txt");
        dir.add(file);
        dir.remove(file);
        assertDoesNotThrow(dir::showInfo);
    }
}
