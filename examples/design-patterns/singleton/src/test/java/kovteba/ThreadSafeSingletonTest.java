package kovteba;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeSingletonTest {

    @Test
    void getInstance_returnsSameInstance() {
        ThreadSafeSingleton first = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton second = ThreadSafeSingleton.getInstance();
        assertSame(first, second);
    }

    @Test
    void getInstance_isNotNull() {
        assertNotNull(ThreadSafeSingleton.getInstance());
    }

    @Test
    void getInstance_isSameAcrossThreads() throws Exception {
        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Callable<ThreadSafeSingleton> task = ThreadSafeSingleton::getInstance;

        List<Future<ThreadSafeSingleton>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            futures.add(executor.submit(task));
        }
        executor.shutdown();

        ThreadSafeSingleton expected = ThreadSafeSingleton.getInstance();
        for (Future<ThreadSafeSingleton> f : futures) {
            assertSame(expected, f.get());
        }
    }
}
