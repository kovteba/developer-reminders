package kovteba.classadapter;

// tag::ClassAdapterDemo[]
public class ClassAdapterDemo {

    public static void main(String[] args) {

        Printer printer = new ClassPrinterAdapter();

        printer.print("Hello from Class Adapter!");
    }
}
// end::ClassAdapterDemo[]
