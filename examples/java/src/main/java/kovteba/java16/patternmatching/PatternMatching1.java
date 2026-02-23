package kovteba.java16.patternmatching;

public class PatternMatching1 {
    public static void main(String[] args) {
        Object obj = "Hello Pattern Matching";

        // tag::PatternMatching1Old[]
        if (obj instanceof String) {
            String s = (String) obj; // Ручне приведення
            System.out.println(s.toLowerCase());
        }
        // end::PatternMatching1Old[]

        // tag::PatternMatching1New[]
        if (obj instanceof String s) {
            // Змінна 's' вже доступна і має тип String
            System.out.println(s.toLowerCase());
        }
        // end::PatternMatching1New[]
    }
}
