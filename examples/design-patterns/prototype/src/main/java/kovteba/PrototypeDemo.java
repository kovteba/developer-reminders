package kovteba;

// tag::PrototypeDemo[]
public class PrototypeDemo {
    public static void main(String[] args) {

        Metadata metadata = new Metadata("Dmytro", 1);
        Document original = new Document("Report", "Content...", metadata);

        Document cloned = original.copy();

        System.out.println("Original: " + original);
        System.out.println("Cloned:   " + cloned);

        // Проверим, что копии разные
        System.out.println("Same object? " + (original == cloned));
        System.out.println("Same metadata? " + (original.getMetadata() == cloned.getMetadata()));
    }
}
// end::PrototypeDemo[]
