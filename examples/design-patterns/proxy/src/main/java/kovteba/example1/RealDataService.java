package kovteba.example1;

// tag::RealDataService[]
public class RealDataService implements DataService {

    @Override
    public String loadData(String key) {
        // Імітуємо повільну операцію
        try {
            Thread.sleep(1000); // наприклад, довгий запит до API або БД
        } catch (InterruptedException ignored) {}

        return "Data from server for key: " + key;
    }
}
// end::RealDataService[]
