package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {

    @Test
    void proxy_loadsDataFromRealService_firstCall() {
        DataService proxy = new DataServiceProxy(key -> "value:" + key);
        String result = proxy.loadData("k1");
        assertEquals("value:k1", result);
    }

    @Test
    void proxy_returnsCachedData_secondCall() {
        int[] callCount = {0};
        DataService proxy = new DataServiceProxy(key -> {
            callCount[0]++;
            return "result:" + key;
        });

        proxy.loadData("key1");
        String cached = proxy.loadData("key1");

        assertEquals("result:key1", cached);
        assertEquals(1, callCount[0], "Real service should only be called once");
    }

    @Test
    void proxy_loadsDifferentKeys_independently() {
        DataService proxy = new DataServiceProxy(key -> "data:" + key);
        String r1 = proxy.loadData("a");
        String r2 = proxy.loadData("b");
        assertEquals("data:a", r1);
        assertEquals("data:b", r2);
    }
}
