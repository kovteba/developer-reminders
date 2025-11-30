package kovteba;

// tag::Metadata[]
public class Metadata {
    private String author;
    private int version;

    public Metadata(String author, int version) {
        this.author = author;
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "author='" + author + '\'' +
                ", version=" + version +
                '}';
    }
}
// end::Metadata[]
