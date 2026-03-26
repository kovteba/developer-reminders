package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyweightTest {

    @Test
    void getGlyph_sameCharacter_returnsSameInstance() {
        Glyph g1 = GlyphFactory.getGlyph('A');
        Glyph g2 = GlyphFactory.getGlyph('A');
        assertSame(g1, g2);
    }

    @Test
    void getGlyph_differentCharacters_returnDifferentInstances() {
        Glyph g1 = GlyphFactory.getGlyph('X');
        Glyph g2 = GlyphFactory.getGlyph('Y');
        assertNotSame(g1, g2);
    }

    @Test
    void getGlyph_isNotNull() {
        assertNotNull(GlyphFactory.getGlyph('Z'));
    }

    @Test
    void characterGlyph_draw_doesNotThrow() {
        Glyph glyph = GlyphFactory.getGlyph('B');
        assertDoesNotThrow(() -> glyph.draw(10, 20));
    }

    @Test
    void getGlyph_multipleUniqueChars_allCached() {
        char[] chars = {'a', 'b', 'c', 'd'};
        for (char c : chars) {
            Glyph first = GlyphFactory.getGlyph(c);
            Glyph second = GlyphFactory.getGlyph(c);
            assertSame(first, second, "Expected same instance for char: " + c);
        }
    }
}
