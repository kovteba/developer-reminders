package kovteba.example1;

// tag::Component[]
/**
 * Component — спільний інтерфейс для всіх елементів дерева:
 * і для "листя" (File), і для "композитів" (Directory).
 */
public interface Component {
    void showInfo(); // універсальна операція
}
// end::Component[]