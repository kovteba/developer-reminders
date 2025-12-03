package kovteba.example1;

import java.util.HashMap;
import java.util.Map;

// tag::DataServiceProxy[]
public class DataServiceProxy implements DataService {

    private final DataService realService;
    private final Map<String, String> cache = new HashMap<>();

    public DataServiceProxy(DataService realService) {
        this.realService = realService;
    }

    @Override
    public String loadData(String key) {

        // 1) Якщо дані є в кеші — повертаємо миттєво
        if (cache.containsKey(key)) {
            System.out.println("✔ Returning cached result for: " + key);
            return cache.get(key);
        }

        // 2) Інакше — звертаємось до реального сервісу
        System.out.println("⏳ Loading from RealDataService...");
        String result = realService.loadData(key);

        // 3) Зберігаємо в кеш
        cache.put(key, result);

        return result;
    }
}
// end::DataServiceProxy[]
