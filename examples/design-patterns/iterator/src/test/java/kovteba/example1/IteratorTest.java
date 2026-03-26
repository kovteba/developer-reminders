package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    @Test
    void nameIterator_hasNext_returnsTrueForNonEmptyArray() {
        NameCollection col = new NameCollection(new String[]{"Alice", "Bob"});
        Iterator<String> it = col.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    void nameIterator_hasNext_returnsFalseForEmptyArray() {
        NameCollection col = new NameCollection(new String[]{});
        Iterator<String> it = col.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    void nameIterator_next_returnsElementsInOrder() {
        NameCollection col = new NameCollection(new String[]{"Alice", "Bob", "Carol"});
        Iterator<String> it = col.iterator();
        assertEquals("Alice", it.next());
        assertEquals("Bob", it.next());
        assertEquals("Carol", it.next());
    }

    @Test
    void nameIterator_hasNext_returnsFalseAfterAllElementsConsumed() {
        NameCollection col = new NameCollection(new String[]{"only"});
        Iterator<String> it = col.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void nameCollection_providesFreshIteratorEachCall() {
        NameCollection col = new NameCollection(new String[]{"X", "Y"});
        Iterator<String> it1 = col.iterator();
        Iterator<String> it2 = col.iterator();
        assertNotSame(it1, it2);
        assertEquals(it1.next(), it2.next());
    }
}
