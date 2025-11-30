package kovteba;

// tag::SingletonDemo[]
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2); // true
    }
}
// end::SingletonDemo[]
