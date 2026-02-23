package kovteba.java22.unnamedvariables;

// tag::UnnamedVariables2[]
record Order(int id, String item) {}

public class UnnamedVariables2 {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Book"),
            new Order(2, "Laptop"),
            new Order(3, "Phone")
        };
        for (Order _ : orders) {
            totalOrdersCount++; // Рахуємо кількість, але сам об'єкт order не використовуємо
        }
    }

    static int totalOrdersCount = 0;
}
// end::UnnamedVariables2[]
