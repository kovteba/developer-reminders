package kovteba.java16.record.record3;

// tag::Record3Demo[]
public class Record3Demo {
    public static void main(String[] args) {
        Point point = new Point(10, 20);
        point.run();
        System.out.println(point); // Point[x=10, y=20]
    }
}
// end::Record3Demo[]
