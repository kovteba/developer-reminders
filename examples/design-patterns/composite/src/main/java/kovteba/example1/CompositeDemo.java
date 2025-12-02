package kovteba.example1;

// tag::CompositeDemo[]
/**
 * CompositeDemo — демонстрація роботи патерна Composite.
 */
public class CompositeDemo {

    public static void main(String[] args) {

        // Листя
        FileComponent file1 = new FileComponent("README.md");
        FileComponent file2 = new FileComponent("design.png");
        FileComponent file3 = new FileComponent("notes.txt");

        // Папки (композити)
        DirectoryComponent imagesDir = new DirectoryComponent("images");
        DirectoryComponent docsDir = new DirectoryComponent("docs");
        DirectoryComponent projectRoot = new DirectoryComponent("project");

        // Будуємо дерево
        imagesDir.add(file2);
        docsDir.add(file1);
        docsDir.add(file3);

        projectRoot.add(imagesDir);
        projectRoot.add(docsDir);

        // Виводимо структуру
        projectRoot.showInfo();
    }
}
// end::CompositeDemo[]
