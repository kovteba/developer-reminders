package kovteba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazySingletonTest {

    @Test
    void getInstance_returnsSameInstance() {
        LazySingleton first = LazySingleton.getInstance();
        LazySingleton second = LazySingleton.getInstance();
        assertSame(first, second);
    }

    @Test
    void getInstance_isNotNull() {
        assertNotNull(LazySingleton.getInstance());
    }
}
