package kovteba.example1;

// tag::FlyweightDemo[]
// Демонстрація Flyweight
public class FlyweightDemo {
    public static void main(String[] args) {

        String text = "HELLO";

        int x = 0;

        for (char ch : text.toCharArray()) {
            Glyph glyph = GlyphFactory.getGlyph(ch); // reuse з кешу
            glyph.draw(x, 10);
            x += 10;
        }

        System.out.println("\nCache size: " + GlyphFactory.getGlyph('H')); // показує reuse
    }
}
// end::FlyweightDemo[]
