package kovteba.java21.patternmatching;

public class PatternMatching6 {
    public static void main(String[] args) {
        // tag::PatternMatching6[]
        Object obj = null;
        switch (obj) {
            case null -> System.out.println("Отримано null, нічого не робимо.");
            case String s -> System.out.println("Це рядок: " + s);
            case Integer i -> System.out.println("Це число: " + i);
            default -> System.out.println("Невідомий тип");
        }
        // end::PatternMatching6[]
    }
}
