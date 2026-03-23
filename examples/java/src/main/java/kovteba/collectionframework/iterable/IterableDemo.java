package kovteba.collectionframework.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableDemo {
    public static void main(String[] args) {

        // tag::IterableDemo1[]
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("b")) it.remove(); // безпечно
        }
        // list = ["a", "c"]
        // end::IterableDemo1[]

    }
}
