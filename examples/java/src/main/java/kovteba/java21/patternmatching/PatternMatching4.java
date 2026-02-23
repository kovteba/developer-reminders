package kovteba.java21.patternmatching;

public class PatternMatching4 {
    public static void main(String[] args) {
        testString("Short");
        testString("A very long string");
        testString(100);
    }

    static void testString(Object obj) {
        switch (obj) {
            case String s when s.length() > 5 ->
                    System.out.println("Довгий рядок: " + s);
            case String s ->
                    System.out.println("Короткий рядок: " + s);
            default ->
                    System.out.println("Не рядок");
        }
    }
}




