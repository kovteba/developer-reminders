package kovteba.example1;

// tag::VisitorDemo[]
public class VisitorDemo {
    public static void main(String[] args) {

        DirectoryElement root = new DirectoryElement("root");
        root.add(new FileElement("readme.txt", 100));
        root.add(new FileElement("logo.png", 800));

        DirectoryElement docs = new DirectoryElement("docs");
        docs.add(new FileElement("resume.pdf", 300));
        docs.add(new FileElement("book.pdf", 900));

        root.add(docs);

        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        root.accept(visitor);

        System.out.println("Total size: " + visitor.getTotalSize() + " KB");
    }
}
// end::VisitorDemo[]
/*
// tag::VisitorDemoResult[]
Total size: 2100 KB
// end::VisitorDemoResult[]
*/