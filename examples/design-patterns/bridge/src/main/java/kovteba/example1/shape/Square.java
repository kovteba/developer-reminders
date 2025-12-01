package kovteba.example1.shape;

import kovteba.example1.renderer.Renderer;

// tag::Square[]
public class Square extends Shape {

    private double size;

    public Square(Renderer renderer, double size) {
        super(renderer);
        this.size = size;
    }

    @Override
    public void draw() {
        renderer.renderShape("Square with size " + size);
    }

    @Override
    public void resize(double factor) {
        size *= factor;
        System.out.println("Resized square to size " + size);
    }
}
// end::Square[]
