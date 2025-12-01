package kovteba.example1.renderer;

// tag::RasterRenderer[]
public class RasterRenderer implements Renderer {

    @Override
    public void renderShape(String shapeName) {
        System.out.println("Rendering " + shapeName + " as RASTER graphics");
    }
}
// end::RasterRenderer[]
