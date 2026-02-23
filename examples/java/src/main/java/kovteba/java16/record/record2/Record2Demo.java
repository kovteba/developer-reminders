package kovteba.java16.record.record2;

// tag::Record2Demo[]
public class Record2Demo {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1200.0);
        System.out.println(product); // Product[name=Laptop, price=1200.0]

        // Спроба створити продукт з від'ємною ціною
        try {
            Product invalidProduct = new Product("Smartphone", -500.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Ціна не може бути від'ємною!
        }
    }
}
// end::Record2Demo[]
