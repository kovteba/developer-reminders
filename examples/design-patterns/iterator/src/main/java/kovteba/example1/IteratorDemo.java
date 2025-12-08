package kovteba.example1;

// tag::IteratorDemo[]
public class IteratorDemo {
    public static void main(String[] args) {
        String[] people = {"Alice", "Bob", "Charlie", "Diana"};

        NameCollection collection = new NameCollection(people);
        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
// end::IteratorDemo[]
