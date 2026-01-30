package kovteba.java21.patternmatching;

public class PatternMatching1 {
    public static void main(String[] args) {
        Object obj = "Hello Pattern Matching";
    }

    // tag::PatternMatching1Old[]
    public static String oldFormatter(Object obj) {
        if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            return String.format("Це ціле число: %d", i);
        } else if (obj instanceof Long) {
            Long l = (Long) obj;
            return String.format("Це довге ціле: %d", l);
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            return String.format("Це число з комою: %f", d);
        } else if (obj instanceof String) {
            String s = (String) obj;
            return String.format("Це рядок: %s", s);
        } else if (obj == null) {
            return "Об'єкт дорівнює null!";
        } else {
            return obj.toString();
        }
    }
    // end::PatternMatching1Old[]

    // tag::PatternMatching1New[]
    public static String formatter(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("Це ціле число: %d", i);
            case Long l    -> String.format("Це довге ціле: %d", l);
            case Double d  -> String.format("Це число з комою: %f", d);
            case String s  -> String.format("Це рядок: %s", s);
            case null      -> "Об'єкт дорівнює null!";
            default        -> obj.toString();
        };
    }
    // end::PatternMatching1New[]
}
