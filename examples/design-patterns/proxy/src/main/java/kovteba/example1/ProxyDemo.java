package kovteba.example1;

// tag::ProxyDemo[]
public class ProxyDemo {
    public static void main(String[] args) {

        DataService realService = new RealDataService();
        DataService proxy = new DataServiceProxy(realService);

        System.out.println(proxy.loadData("user123"));
        System.out.println("---");
        System.out.println(proxy.loadData("user123")); // тут уже кеш
    }
}
// end::ProxyDemo[]
