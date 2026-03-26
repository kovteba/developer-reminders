package kovteba.classadapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassAdapterTest {

    @Test
    void classAdapter_implementsPrinterInterface() {
        Printer adapter = new ClassPrinterAdapter();
        assertNotNull(adapter);
    }

    @Test
    void classAdapter_print_doesNotThrow() {
        Printer adapter = new ClassPrinterAdapter();
        assertDoesNotThrow(() -> adapter.print("Hello"));
    }

    @Test
    void classAdapter_print_withNullMessage_doesNotThrow() {
        Printer adapter = new ClassPrinterAdapter();
        assertDoesNotThrow(() -> adapter.print(null));
    }

    @Test
    void legacyPrinter_printData_doesNotThrow() {
        LegacyPrinter legacy = new LegacyPrinter();
        assertDoesNotThrow(() -> legacy.printData("test"));
    }
}
