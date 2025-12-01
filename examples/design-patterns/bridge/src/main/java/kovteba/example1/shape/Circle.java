package kovteba.example1.shape;

import kovteba.example1.renderer.Renderer;

// tag::Circle[]
public class Circle extends Shape {

    private double radius;

    public Circle(Renderer renderer, double radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderShape("Circle with radius " + radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resized circle to radius " + radius);
    }
}
// end::Circle[]
