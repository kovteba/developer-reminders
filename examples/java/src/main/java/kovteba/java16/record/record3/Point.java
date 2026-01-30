package kovteba.java16.record.record3;

// tag::Point[]
public record Point(int x, int y) implements Runnable {

    public static final Point ORIGIN = new Point(0, 0);

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public void run() {
        System.out.println("Точка на координатах: " + x + ", " + y);
    }
}
// end::Point[]
