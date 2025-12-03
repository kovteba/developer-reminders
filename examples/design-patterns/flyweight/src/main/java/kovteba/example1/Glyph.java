package kovteba.example1;

// tag::Glyph[]
// Спільний інтерфейс Flyweight (intrinsic state)
public interface Glyph {
    void draw(int x, int y); // extrinsic state передається ззовні
}
// end::Glyph[]
