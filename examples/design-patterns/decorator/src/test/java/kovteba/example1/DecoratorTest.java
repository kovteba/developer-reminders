package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

    @Test
    void simpleMessage_returnsOriginalContent() {
        Message msg = new SimpleMessage("Hello");
        assertEquals("Hello", msg.getContent());
    }

    @Test
    void encryptDecorator_reversesContent() {
        Message msg = new EncryptDecorator(new SimpleMessage("Hello"));
        assertEquals("olleH", msg.getContent());
    }

    @Test
    void encryptDecorator_emptyString_returnsEmpty() {
        Message msg = new EncryptDecorator(new SimpleMessage(""));
        assertEquals("", msg.getContent());
    }

    @Test
    void encryptDecorator_singleChar_returnsSameChar() {
        Message msg = new EncryptDecorator(new SimpleMessage("A"));
        assertEquals("A", msg.getContent());
    }

    @Test
    void logDecorator_returnsOriginalContent() {
        Message msg = new LogDecorator(new SimpleMessage("World"));
        assertEquals("World", msg.getContent());
    }

    @Test
    void encryptThenLog_returnsReversedContent() {
        Message msg = new LogDecorator(new EncryptDecorator(new SimpleMessage("Java")));
        assertEquals("avaJ", msg.getContent());
    }

    @Test
    void logThenEncrypt_returnsReversedContent() {
        Message msg = new EncryptDecorator(new LogDecorator(new SimpleMessage("Test")));
        assertEquals("tseT", msg.getContent());
    }
}
