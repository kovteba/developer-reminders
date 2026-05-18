package kovteba.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        List.of("one", "two", "three", "four", "five")
                .stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
