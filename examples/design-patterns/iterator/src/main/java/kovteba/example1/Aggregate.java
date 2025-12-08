package kovteba.example1;

// tag::Aggregate[]
public interface Aggregate<T> {
    Iterator<T> iterator();
}
// end::Aggregate[]
