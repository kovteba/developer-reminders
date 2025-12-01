package kovteba.classadapter;

// tag::ClassPrinterAdapter[]
public class ClassPrinterAdapter extends LegacyPrinter implements Printer {

    @Override
    public void print(String message) {
        // Використовуємо метод батьківського класу
        printData(message);
    }
}
// end::ClassPrinterAdapter[]
