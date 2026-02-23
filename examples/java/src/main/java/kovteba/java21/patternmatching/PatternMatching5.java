package kovteba.java21.patternmatching;

public class PatternMatching5 {
    public static void main(String[] args) {
        // tag::PatternMatching5Exit[]
        Object obj = "Hello, World!";

        if (obj instanceof String s && s.length() > 5) {
            // Тут 's' доступна, бо ліва частина && виконалась успішно
            System.out.println(s.toUpperCase());
        }
        // end::PatternMatching5Exit[]

        // tag::PatternMatching5And[]
        if (!(obj instanceof String s)) {
            // Тут 's' НЕ доступна
            return;
        }
        // Оскільки ми не вийшли вище, компілятор ЗНАЄ, що 's' точно String
        System.out.println("Довжина рядка: " + s.length());
        // end::PatternMatching5And[]
    }
}
