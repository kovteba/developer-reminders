package kovteba.java16.record.record1;

// tag::Record1Demo[]
public class Record1Demo {
    public static void main(String[] args) {
        User user = new User(1L, "Ivan", "ivan@example.com");
        System.out.println(user.name()); // Геттер без "get"
        System.out.println(user);        // User[id=1, name=Ivan, email=ivan@example.com]
    }
}
// end::Record1Demo[]
