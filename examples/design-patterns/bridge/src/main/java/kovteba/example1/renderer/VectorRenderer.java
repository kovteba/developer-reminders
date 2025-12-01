package kovteba.example1.renderer;

// tag::VectorRenderer[]
public class VectorRenderer implements Renderer {

    @Override
    public void renderShape(String shapeName) {
        System.out.println("Rendering " + shapeName + " as VECTOR graphics");
    }
}
// end::VectorRenderer[]
