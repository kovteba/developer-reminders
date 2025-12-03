package kovteba.example1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// tag::GlyphFactory[]
// Фабрика Flyweight — повертає вже існуючі символи з кешу
public class GlyphFactory {

    private static final Map<Character, Glyph> cache = new ConcurrentHashMap<>();

    public static Glyph getGlyph(char ch) {
        return cache.computeIfAbsent(ch, CharacterGlyph::new);
    }
}
// end::GlyphFactory[]
