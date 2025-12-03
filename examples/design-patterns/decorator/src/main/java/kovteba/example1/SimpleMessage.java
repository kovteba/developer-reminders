package kovteba.example1;

// tag::SimpleMessage[]
/**
 * Просте текстове повідомлення.
 */
public class SimpleMessage implements Message {

    private final String text;

    public SimpleMessage(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
}
// end::SimpleMessage[]
