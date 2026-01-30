package kovteba.java17.sealedclass.sealedclass2;

// tag::SealedClass2Demo[]
public class SealedClass2Demo {
    public static void main(String[] args) {
        OrderStatus myStatus = new Shipped("ABC-123");
        System.out.println(getStatusMessage(myStatus));
    }

    public static String getStatusMessage(OrderStatus status) {
        return switch (status) {
            case Created c -> "Замовлення #" + c.orderId() + " створено.";
            case Shipped s -> "У дорозі: " + s.trackingNumber();
            case Delivered d -> "Доставлено!";
            case Cancelled c -> "Скасовано: " + c.reason();
        };
    }
}

sealed interface OrderStatus permits Created, Shipped, Delivered, Cancelled {}

record Created(long orderId) implements OrderStatus {}
record Shipped(String trackingNumber) implements OrderStatus {}
record Delivered() implements OrderStatus {}
record Cancelled(String reason) implements OrderStatus {}
// end::SealedClass2Demo[]
