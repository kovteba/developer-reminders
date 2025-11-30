package kovteba.objectadapter;

// tag::PrinterAdapter[]
public class PrinterAdapter implements Printer {

    private final LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String message) {
        // Перетворюємо виклик під сучасний інтерфейс
        legacyPrinter.printData(message);
    }
}
// end::PrinterAdapter[]