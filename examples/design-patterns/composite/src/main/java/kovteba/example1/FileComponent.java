package kovteba.example1;

// tag::FileComponent[]
/**
 * FileComponent — листовий елемент (файл).
 * Не містить інших компонентів.
 */
public class FileComponent implements Component {

    private final String name;

    public FileComponent(String name) {
        this.name = name;
    }

    @Override
    public void showInfo() {
        System.out.println("File: " + name);
    }
}
// end::FileComponent[]
