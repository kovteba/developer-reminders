package kovteba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentPrototypeTest {

    @Test
    void copy_returnsNewInstance() {
        Document original = new Document("Title", "Content", new Metadata("Alice", 1));
        Document copy = original.copy();
        assertNotSame(original, copy);
    }

    @Test
    void copy_hasDeepCopiedMetadata() {
        Metadata originalMetadata = new Metadata("Alice", 1);
        Document original = new Document("Title", "Content", originalMetadata);
        Document copy = original.copy();

        assertNotSame(original.getMetadata(), copy.getMetadata());
    }

    @Test
    void copy_preservesMetadataValues() {
        Document original = new Document("Doc", "Body", new Metadata("Bob", 3));
        Document copy = original.copy();

        assertEquals("Bob", copy.getMetadata().getAuthor());
        assertEquals(3, copy.getMetadata().getVersion());
    }

    @Test
    void metadata_gettersReturnCorrectValues() {
        Metadata m = new Metadata("Carol", 5);
        assertEquals("Carol", m.getAuthor());
        assertEquals(5, m.getVersion());
    }
}
