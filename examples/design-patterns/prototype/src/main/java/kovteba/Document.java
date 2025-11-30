package kovteba;

// tag::Document[]
public class Document implements Prototype<Document> {

    private String title;
    private String content;
    private Metadata metadata;

    public Document(String title, String content, Metadata metadata) {
        this.title = title;
        this.content = content;
        this.metadata = metadata;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    // Глубокое копирование
    @Override
    public Document copy() {
        return new Document(
                this.title,
                this.content,
                new Metadata(metadata.getAuthor(), metadata.getVersion())
        );
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
// end::Document[]
