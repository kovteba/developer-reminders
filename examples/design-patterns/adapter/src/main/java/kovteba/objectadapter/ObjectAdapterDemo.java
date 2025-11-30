package kovteba.objectadapter;

// tag::ObjectAdapterDemo[]
public class ObjectAdapterDemo {

    public static void main(String[] args) {

        LegacyPrinter oldPrinter = new LegacyPrinter();

        // Адаптер робить старий клас сумісним із новим інтерфейсом
        Printer printer = new PrinterAdapter(oldPrinter);

        printer.print("Hello Adapter Pattern!");
    }
}
// end::ObjectAdapterDemo[]
