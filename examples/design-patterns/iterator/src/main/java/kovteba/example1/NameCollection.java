package kovteba.example1;

// tag::NameCollection[]
public class NameCollection implements Aggregate<String> {

    private final String[] names;

    public NameCollection(String[] names) {
        this.names = names;
    }

    @Override
    public Iterator<String> iterator() {
        return new NameIterator(names);
    }
}
// end::NameCollection[]
