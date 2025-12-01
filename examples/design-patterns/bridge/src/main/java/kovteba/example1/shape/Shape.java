package kovteba.example1.shape;

import kovteba.example1.renderer.Renderer;

// tag::Shape[]
public abstract class Shape {

    protected final Renderer renderer;

    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(double factor);
}
// end::Shape[]
