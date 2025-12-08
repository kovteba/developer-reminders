package kovteba.example1;

// tag::NameIterator[]
public class NameIterator implements Iterator<String> {

    private final String[] items;
    private int position = 0;

    public NameIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public String next() {
        return items[position++];
    }
}
// end::NameIterator[]
