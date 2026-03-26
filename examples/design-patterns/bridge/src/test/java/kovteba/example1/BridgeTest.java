package kovteba.example1;

import kovteba.example1.renderer.RasterRenderer;
import kovteba.example1.renderer.VectorRenderer;
import kovteba.example1.shape.Circle;
import kovteba.example1.shape.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    void circle_drawWithVectorRenderer_doesNotThrow() {
        Circle circle = new Circle(new VectorRenderer(), 5.0);
        assertDoesNotThrow(circle::draw);
    }

    @Test
    void circle_drawWithRasterRenderer_doesNotThrow() {
        Circle circle = new Circle(new RasterRenderer(), 5.0);
        assertDoesNotThrow(circle::draw);
    }

    @Test
    void circle_resize_updatesRadius() {
        Circle circle = new Circle(new VectorRenderer(), 10.0);
        assertDoesNotThrow(() -> circle.resize(2.0));
    }

    @Test
    void square_drawWithVectorRenderer_doesNotThrow() {
        Square square = new Square(new VectorRenderer(), 4.0);
        assertDoesNotThrow(square::draw);
    }

    @Test
    void square_drawWithRasterRenderer_doesNotThrow() {
        Square square = new Square(new RasterRenderer(), 4.0);
        assertDoesNotThrow(square::draw);
    }

    @Test
    void square_resize_updatesSize() {
        Square square = new Square(new RasterRenderer(), 6.0);
        assertDoesNotThrow(() -> square.resize(0.5));
    }

    @Test
    void rasterRenderer_renderShape_doesNotThrow() {
        RasterRenderer renderer = new RasterRenderer();
        assertDoesNotThrow(() -> renderer.renderShape("Circle"));
    }

    @Test
    void vectorRenderer_renderShape_doesNotThrow() {
        VectorRenderer renderer = new VectorRenderer();
        assertDoesNotThrow(() -> renderer.renderShape("Square"));
    }
}
