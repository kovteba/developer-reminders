package kovteba.example1;

import kovteba.example1.renderer.RasterRenderer;
import kovteba.example1.renderer.Renderer;
import kovteba.example1.renderer.VectorRenderer;
import kovteba.example1.shape.Circle;
import kovteba.example1.shape.Shape;
import kovteba.example1.shape.Square;

// tag::BridgeDemo[]
public class BridgeDemo {

    public static void main(String[] args) {

        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();

        Shape circle = new Circle(vector, 10);
        Shape square = new Square(raster, 5);

        circle.draw();
        circle.resize(2);

        System.out.println();

        square.draw();
        square.resize(3);
    }
}
// end::BridgeDemo[]
