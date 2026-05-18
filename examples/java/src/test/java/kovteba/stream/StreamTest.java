package kovteba.stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

public class StreamTest {

    @Test
    void streamTest1() {

        /*
        // tag::streamTest1[]
        Stream<String> stream = List.of("1", "2").stream();
        stream.forEach(System.out::println);
        stream.filter(s -> s.contains("1"));
        // end::streamTest1[]

        // tag::streamTest1Variants[]
        1. Помилки відсутні
        2. stream has already been operated upon or closed
        3. Невірни тип
        4. Помилка компіляції
        // end::streamTest1Variants[]
        // tag::streamTest1Answer[]
        Answer: stream has already been operated upon or closed
        Description:
        // end::streamTest1Answer[]
        */
    }

    @Test
    void streamTest2() {

        // tag::streamTest2[]
        UnaryOperator<Integer> unaryOperator = x -> x + 1;
        Stream.iterate(2, unaryOperator).limit(4).forEach(System.out::println);
        // end::streamTest2[]
        /*
        // tag::streamTest2Variants[]
        1. 2, 3, 4, 5
        2. Помилка компіляції
        3. Нескінчений стрім
        4. Нічого
        // end::streamTest2Variants[]
        // tag::streamTest2Answer[]
        Answer: 2, 3, 4, 5
        Description:
        // end::streamTest2Answer[]
        */
    }

    @Test
    void streamTest3() {

        // tag::streamTest3[]
        UnaryOperator<Integer> unaryOperator = x -> x + 1;
        Predicate<Integer> predicate = x -> x < 10;
        Stream.iterate(2, predicate, unaryOperator).forEach(System.out::println);
        // end::streamTest3[]
        /*
        // tag::streamTest3Variants[]
        1. Нічого
        2. 2, 3, 4, 5, 6, 7, 8, 9, 10
        3. 2, 3, 4, 5, 6, 7, 8, 9
        4. 3, 4, 5, 6, 7, 8, 9, 10
        // end::streamTest3Variants[]
        // tag::streamTest3Answer[]
        Answer: 2, 3, 4, 5, 6, 7, 8, 9
        Description:
        // end::streamTest3Answer[]
        */
    }

    @Test
    void streamTest4() {

        // tag::streamTest4[]
        Stream.concat(Stream.of(8, 7, 3),
                      Stream.of(4, 1, 6))
              .forEach(System.out::print);
        // end::streamTest4[]
        /*
        // tag::streamTest4Variants[]
        1. 8, 7, 3, 4, 1 ,6
        2. 1, 3, 4, 6, 7, 8
        3. Помилка компіляції
        4. Нічого
        // end::streamTest4Variants[]
        // tag::streamTest4Answer[]
        Answer: 8, 7, 3, 4, 1 ,6
        Description:
        // end::streamTest4Answer[]
        */
    }

    @Test
    void streamTest5() {

        // tag::streamTest5[]
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                                                     .add(0)
                                                     .add(1);

        for (int i = 0; i <= 4; i++) {
            streamBuider.accept(i);
        }

        streamBuider.add(0)
                    .add(1)
                    .build()
                    .forEach(System.out::print);
        // end::streamTest5[]
        /*
        // tag::streamTest5Variants[]
        1. 0, 1, 0, 1
        2. Помилка компіляції
        3. stream has already been operated upon or closed
        4. 0, 1, 0, 1, 2, 3, 4, 0, 1
        // end::streamTest5Variants[]
        // tag::streamTest5Answer[]
        Answer: 0, 1, 0, 1, 2, 3, 4, 0, 1
        Description:
        // end::streamTest5Answer[]
        */
    }

    @Test
    void streamTest6() {

        // tag::streamTest6[]
        IntStream.range(0, 10).forEach(System.out::print);
        LongStream.range(-10L, -0L).forEach(System.out::print);
        // end::streamTest6[]
        /*
        // tag::streamTest6Variants[]
        1. 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1
        2. 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0
        3. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0
        4. 1, 2, 3, 4, 5, 6, 7, 8, 9, -9, -8, -7, -6, -5, -4, -3, -2, -1
        // end::streamTest6Variants[]
        // tag::streamTest6Answer[]
        Answer: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1
        Description:
        // end::streamTest6Answer[]
        */
    }

    @Test
    void streamTest7() {

        // tag::streamTest7[]
        IntStream.rangeClosed(0, 5).forEach(System.out::print);
        LongStream.range(-5L, -0L).forEach(System.out::print);
        // end::streamTest7[]
        /*
        // tag::streamTest7Variants[]
        1. 1, 2, 3, 4, 5, -4, -3, -2, -1
        2. 0, 1, 2, 3, 4, 5, -5, -4, -3, -2, -1
        3. 0, 1, 2, 3, 4, -5, -4, -3, -2
        4. 1, 2, 3, 4, -5, -4, -3, -2
        // end::streamTest7Variants[]
        // tag::streamTest7Answer[]
        Answer: 0, 1, 2, 3, 4, 5, -5, -4, -3, -2, -1
        Description:
        // end::streamTest7Answer[]
        */
    }

    @Test
    void streamTest8() {

        // tag::streamTest8[]
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        stream.forEach(System.out::print);
        // end::streamTest8[]
        /*
        // tag::streamTest8Variants[]
        1. EmptyStreamError
        2. Нічого
        3. Помилка компіляції
        4. null
        // end::streamTest8Variants[]
        // tag::streamTest8Answer[]
        Answer: Нічого
        Description:
        // end::streamTest8Answer[]
        */
    }

    @Test
    void streamTest9() {

        // tag::streamTest9[]
        Stream<String> streamFromValue = Stream.of("1", "2", "3");
        streamFromValue.forEach(System.out::print);
        // end::streamTest9[]
        /*
        // tag::streamTest9Variants[]
        1. Нічого
        2. 1, 2, 3
        3. Помилка компіляції
        4. WrongTypeError
        // end::streamTest9Variants[]
        // tag::streamTest9Answer[]
        Answer: 1, 2, 3
        Description:
        // end::streamTest9Answer[]
        */
    }

    @Test
    void streamTest10() {

        // tag::streamTest10[]
        Integer[] array = new Integer[]{1, 2, 3};
        Stream<Integer> stream = Arrays.stream(array);
        stream.forEach(System.out::print);
        // end::streamTest10[]
        /*
        // tag::streamTest10Variants[]
        1. WrongTypeError
        2. Нічого
        3. Помилка компіляції
        4. 1, 2, 3
        // end::streamTest10Variants[]
        // tag::streamTest10Answer[]
        Answer: 1, 2, 3
        Description:
        // end::streamTest10Answer[]
        */
    }

    @Test
    void streamTest11() throws IOException {

        /*
        // tag::streamTest11[]
        Stream<String> streamFromFile = Files.lines(Paths.get("path"));
        // end::streamTest11[]

        // tag::streamTest11Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest11Variants[]
        // tag::streamTest11Answer[]
        Answer:
        Description:
        // end::streamTest11Answer[]
        */
    }

    @Test
    void streamTest12() {

        // tag::streamTest12[]
        String s = "123";
        IntStream streamFromString = s.chars();
        streamFromString.forEach(System.out::print);
        // end::streamTest12[]
        /*
        // tag::streamTest12Variants[]
        1. Нічого
        2. 1, 2, 3
        3. 495051
        4. Помилка компіляції
        // end::streamTest12Variants[]
        // tag::streamTest12Answer[]
        Answer: 495051
        Description:
        // end::streamTest12Answer[]
        */
    }

    @Test
    void streamTest13() {

        // tag::streamTest13[]
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.parallelStream();
        // end::streamTest13[]
        /*
        // tag::streamTest13Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest13Variants[]
        // tag::streamTest13Answer[]
        Answer:
        Description:
        // end::streamTest13Answer[]
        */
    }

    @Test
    void streamTest14() {

        // tag::streamTest14[]
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = list.stream().mapToInt(((p) -> p % 2 == 1 ? p : 0)).sum();
        System.out.println(result);
        // end::streamTest14[]
        /*
        // tag::streamTest14Variants[]
        1. 55
        2. 30
        3. 25
        4. Нічого
        // end::streamTest14Variants[]
        // tag::streamTest14Answer[]
        Answer: 25
        Description:
        // end::streamTest14Answer[]
        */
    }

    @Test
    void streamTest15() {

        /*
        // tag::streamTest15[]
        Stream<String> generate = Stream.generate(() -> "s");
        generate.forEach(System.out::print);
        // end::streamTest15[]

        // tag::streamTest15Variants[]
        1. Нічого
        2. s
        3. Нескінчений стрім
        4. Помилка компіляції
        // end::streamTest15Variants[]
        // tag::streamTest15Answer[]
        Answer: Нескінчений стрім
        Description:
        // end::streamTest15Answer[]
        */
    }

    @Test
    void streamTest16() {

        // tag::streamTest16[]
        List<String> list = List.of("1", "", "2", "");
        long count = list.stream().filter(String::isEmpty).count();
        System.out.println(count);
        // end::streamTest16[]
        /*
        // tag::streamTest16Variants[]
        1. 4
        2. 0
        3. Помилка компіляції
        4. 2
        // end::streamTest16Variants[]
        // tag::streamTest16Answer[]
        Answer: 2
        Description:
        // end::streamTest16Answer[]
        */
    }

    @Test
    void streamTest17() {

        // tag::streamTest17[]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Function<Integer, String> function = String::valueOf;
        List<String> strings = numbers.stream().map(function).collect(Collectors.toList());
        strings.forEach(System.out::print);
        // end::streamTest17[]
        /*
        // tag::streamTest17Variants[]
        1. null
        2. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        3. Помилку у 3 рідку
        4. WrongTypeError
        // end::streamTest17Variants[]
        // tag::streamTest17Answer[]
        Answer: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        Description:
        // end::streamTest17Answer[]
        */
    }


    @Test
    void streamTest18() {

        // tag::streamTest18[]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        list.forEach(System.out::print);
        // end::streamTest18[]
        /*
        // tag::streamTest18Variants[]
        1. Помилка компіляції
        2. null
        3. 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
        4. 3628800
        // end::streamTest18Variants[]
        // tag::streamTest18Answer[]
        Answer: 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
        Description:
        // end::streamTest18Answer[]
        */
    }

    @Test
    void streamTest19() {

        // tag::streamTest19[]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        list.forEach(System.out::print);
        // end::streamTest19[]
        /*
        // tag::streamTest19Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest19Variants[]
        // tag::streamTest19Answer[]
        Answer:
        Description:
        // end::streamTest19Answer[]
        */
    }

    @Test
    void streamTest20() {

        // tag::streamTest20[]
        Stream.of(2, 3) // 1
              .flatMapToInt(x -> IntStream.range(0, x)) // 2
              .forEach(System.out::print); // 3
        // end::streamTest20[]
        /*
        // tag::streamTest20Variants[]
        1. 0, 1, 0, 1, 2
        2. 0, 1, 2, 0, 1, 2, 3
        3. 1, 2, 1, 2, 3
        4. 2, 3, 2, 3
        // end::streamTest20Variants[]
        // tag::streamTest20Answer[]
        Answer: 0, 1, 0, 1, 2
        Description:
        // end::streamTest20Answer[]
        */
    }

    @Test
    void streamFlatMapFile() {

        // tag::streamFlatMapFile[]
        List<Path> paths = List.of(Path.of("src/test/resources/file1.txt"), Path.of("src/test/resources/file2.txt"));

        paths.stream()
             .flatMap(path -> {
                    try {
                        return Files.lines(path); // Files.lines повертає Stream<String>, який потребує закриття!
                    } catch (IOException e) {
                        return Stream.empty();
                    }
             })
             .forEach(System.out::println);
        // end::streamFlatMapFile[]
    }

    @Test
    void streamTest21() {

        // tag::streamTest21[]
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = list.stream().reduce(Integer::sum).orElse(0);
        System.out.println(result);
        // end::streamTest21[]
        /*
        // tag::streamTest21Variants[]
        1. 55
        2. 0
        3. null
        4. Помилка компіляції
        // end::streamTest21Variants[]
        // tag::streamTest21Answer[]
        Answer: 55
        Description:
        // end::streamTest21Answer[]
        */
    }

    @Test
    void streamTest22() {

        // tag::streamTest22[]
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = list.stream().filter(s1 -> s1 % 2 == 0).reduce(Integer::sum).orElse(0);
        System.out.println(result);
        // end::streamTest22[]
        /*
        // tag::streamTest22Variants[]
        1. 0
        2. 30
        3. 55
        4. null
        // end::streamTest22Variants[]
        // tag::streamTest22Answer[]
        Answer: 30
        Description:
        // end::streamTest22Answer[]
        */
    }

    @Test
    void streamTest23() {

        // tag::streamTest23[]
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Object[] objects = numberList.stream().toArray();
        Integer[] integers = numberList.toArray(Integer[]::new);
        // end::streamTest23[]
        /*
        // tag::streamTest23Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest23Variants[]
        // tag::streamTest23Answer[]
        Answer:
        Description:
        // end::streamTest23Answer[]
        */
    }

    @Test
    void streamTest24() {

        // tag::streamTest24[]
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numberList.stream();
        Stream<Integer> integerStream = stream.filter(x -> x > 3);
        Stream<Integer> integerStream1 = integerStream.filter(x -> x < 9);
        integerStream1.forEach(System.out::print);
        // end::streamTest24[]
        /*
        // tag::streamTest24Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest24Variants[]
        // tag::streamTest24Answer[]
        Answer:
        Description:
        // end::streamTest24Answer[]
        */
    }

    @Test
    void streamTest25() {

        // tag::streamTest25[]
        List<Integer> numberList = Arrays.asList(1, 20, 3, 4, 5, 6, 70, 8, 9, 10);
        BinaryOperator<Integer> binaryOperator = (a, b) -> b > a ? b : a;
        Integer integer = numberList.stream().reduce(1, binaryOperator);
        System.out.println(integer);
        // end::streamTest25[]
        /*
        // tag::streamTest25Variants[]
        1. 1
        2. 70
        3. 20
        4. UnsupportedOperation
        // end::streamTest25Variants[]
        // tag::streamTest25Answer[]
        Answer: 70
        Description:
        // end::streamTest25Answer[]
        */
    }
    static Integer test(Integer a, Integer b) {
        return b > a ? b : a;
    }

    @Test
    void streamTest26() {

        // tag::streamTest26[]
        List<Integer> numberList = Arrays.asList(1, 20, 3, 4, 5, 6, 70, 8, 9, 10);
        Map<String, List<Integer>> collect = numberList.stream().collect(Collectors.groupingBy(r -> r == 5 ? "EQUAL" : r < 5 ? "LESS" : "MORE"));
        System.out.println(collect);
        // end::streamTest26[]
        /*
        // tag::streamTest26Variants[]
        1. null
        2. {MORE=[20, 6, 70, 8, 9, 10], EQUAL=[5], LESS=[1, 3, 4]}
        3. {MORE=[20, 6, 70, 8, 9, 10], LESS=[1, 3, 4]}
        4. Помилка компіляції
        // end::streamTest26Variants[]
        // tag::streamTest26Answer[]
        Answer: {MORE=[20, 6, 70, 8, 9, 10], EQUAL=[5], LESS=[1, 3, 4]}
        Description:
        // end::streamTest26Answer[]
        */
    }

    @Test
    void streamTest27() {

        // tag::streamTest27[]
        List<User> list = Arrays.asList(
                new User("1", -1),
                new User("2", 0),
                new User("3", 3),
                new User("4", 3));
        Map<String, String> collect = list.stream()
                .collect(Collectors.groupingBy(user -> user.getCount() == 0 ? "ZERO" : user.getCount() < 0 ? "LESS" : "MORE", mapping(User::getName, joining(",", "[", "]"))));
        System.out.println(collect);
        // end::streamTest27[]
        /*
        // tag::streamTest27Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest27Variants[]
        // tag::streamTest27Answer[]
        Answer:
        Description:
        // end::streamTest27Answer[]
        */
    }

    class User {

        private String name;
        private Integer count;

        public User(String name, Integer count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    @Test
    void streamTest28() {

        // tag::streamTest28[]
        List<User> list = Arrays.asList(
                new User("1", -1),
                new User("2", 0),
                new User("3", 3),
                new User("4", 3));
        list.stream()
            .peek(user -> user.setCount(user.count + 1))
            .peek(System.out::println)
            .toList();
        // end::streamTest28[]
        /*
        // tag::streamTest28Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest28Variants[]
        // tag::streamTest28Answer[]
        Answer:
        Description:
        // end::streamTest28Answer[]
        */
    }

    private static void x2(Integer x) {
        x = x * 2;
    }

    @Test
    void streamTest29() {

        // tag::streamTest29[]
        List<User> list = Arrays.asList(
                new User("1", -1),
                new User("2", 0),
                new User("3", 3),
                new User("4", 4));
        var findFirst = list.stream()
                                   .filter(Objects::nonNull)
                                   .filter(user -> user.getCount() < 0)
                                   .map(User::getName)
                                   .findFirst()
                                   .orElse(null);
        System.out.println(findFirst);
        // end::streamTest29[]
        /*
        // tag::streamTest29Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest29Variants[]
        // tag::streamTest29Answer[]
        Answer:
        Description:
        // end::streamTest29Answer[]
        */
    }

    @Test
    void streamTest30() {

        // tag::streamTest30[]
        int[] ints = {2, 2, 3, 4, 5, 6};
        UnaryOperator<Integer> unaryOperator = integer -> {
            System.out.println(integer);
            return integer;
        };
        Stream.iterate(0 , i -> ints[i]).limit(ints.length).forEach(System.out::println);
        // end::streamTest30[]
        /*
        // tag::streamTest30Variants[]
        1.
        2.
        3.
        4.
        // end::streamTest30Variants[]
        // tag::streamTest30Answer[]
        Answer:
        Description:
        // end::streamTest30Answer[]
        */
    }

    @Test
    void streamTest31() {

        // tag::streamTest31[]
        List<String> strings = List.of("Apple", "Banana", "Avocado", "Orange", "Apricot");
        OptionalInt a = strings.stream()
                .filter(s -> s.startsWith("A"))
                .flatMap()
                .mapToInt(String::length)
                .max();
        System.out.println(a.orElse(0));
        // end::streamTest31[]
        /*
        // tag::streamTest31Variants[]
        1.
        2. 7
        3.
        4.
        // end::streamTest31Variants[]
        // tag::streamTest31Answer[]
        Answer: 7
        Description:
        // end::streamTest31Answer[]
        */
    }
}


