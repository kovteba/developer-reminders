package kovteba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void getInstance_returnsSameInstance() {
        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();
        assertSame(first, second);
    }

    @Test
    void getInstance_isNotNull() {
        assertNotNull(Singleton.getInstance());
    }
}
