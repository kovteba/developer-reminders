package kovteba.java16.record.record2;

// tag::Product[]
public record Product(String name, double price) {
    public Product {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною!");
        }
        // Поля name та price присвоюються автоматично в кінці цього блоку
    }
}
// end::Product[]
