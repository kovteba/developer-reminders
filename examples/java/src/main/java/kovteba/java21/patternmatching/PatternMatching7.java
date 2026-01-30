package kovteba.java21.patternmatching;

public class PatternMatching7 {
    public static void main(String[] args) {
        /*
        // tag::PatternMatching7Error[]
        Object obj = "Hello, World!";

        switch (obj) {
            case Object o -> // Цей кейс "затінює" всі наступні!
                    System.out.println("Це якийсь об'єкт");
            case String s -> // ПОМИЛКА КОМПІЛЯЦІЇ: Label is dominated by a preceding case label
                    System.out.println("Це рядок");
        }
        // end::PatternMatching7Error[]
        */
        // tag::PatternMatching7Fixed[]
        Object obj = "Hello, World!";

        switch (obj) {
            case String s -> System.out.println("Рядок");
            case Object o -> System.out.println("Будь-що інше");
        }
        // end::PatternMatching7Fixed[]
    }
}
