package kovteba.java22.unnamedvariables;

import java.util.Map;

public class UnnamedVariables4 {
    public static void main(String[] args) {

        // tag::UnnamedVariables4[]
        Map<String, Integer> map = Map.of(
                "Один", 1,
                "Два", 2,
                "Три", 3
        );
        map.forEach((key, _) -> System.out.println("Ключ: " + key));
        // end::UnnamedVariables4[]
    }
}
