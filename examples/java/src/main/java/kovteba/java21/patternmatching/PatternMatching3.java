package kovteba.java21.patternmatching;

// tag::PatternMatching3[]
sealed interface Shape permits Circle, Square {}

record Circle(double radius) implements Shape {}
record Square(double side) implements Shape {}

public class PatternMatching3 {
    public static void main(String[] args) {
        Shape shape = new Circle(5.0);
        System.out.println("Area: " + getArea(shape));
    }

    public static double getArea(Shape shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Square s -> s.side() * s.side();
            // Default действительно не нужен, так как Shape sealed
        };
    }

}
// end::PatternMatching3[]
