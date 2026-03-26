package kovteba.objectadapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectAdapterTest {

    @Test
    void printerAdapter_implementsPrinterInterface() {
        LegacyPrinter legacy = new LegacyPrinter();
        Printer adapter = new PrinterAdapter(legacy);
        assertNotNull(adapter);
    }

    @Test
    void printerAdapter_print_doesNotThrow() {
        Printer adapter = new PrinterAdapter(new LegacyPrinter());
        assertDoesNotThrow(() -> adapter.print("Hello"));
    }

    @Test
    void printerAdapter_print_withNullMessage_doesNotThrow() {
        Printer adapter = new PrinterAdapter(new LegacyPrinter());
        assertDoesNotThrow(() -> adapter.print(null));
    }

    @Test
    void legacyPrinter_printData_doesNotThrow() {
        LegacyPrinter legacy = new LegacyPrinter();
        assertDoesNotThrow(() -> legacy.printData("test"));
    }
}
