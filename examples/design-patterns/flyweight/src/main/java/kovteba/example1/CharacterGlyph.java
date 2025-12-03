package kovteba.example1;

// tag::CharacterGlyph[]
// Конкретний Flyweight — символ, який повторюється багато разів
public class CharacterGlyph implements Glyph {

    private final char character; // intrinsic state — незмінний

    public CharacterGlyph(char character) {
        this.character = character;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Draw '" + character + "' at (" + x + ", " + y + ")");
    }
}
// end::CharacterGlyph[]
