package kovteba.collectionframework.map.hashmap;

import java.util.HashMap;

// tag::HashMapExample2[]
public class HashMapExample2 {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();

        String a = hashMap.put("A", "1");
        String b = hashMap.put("B", "2");
        String c = hashMap.put("C", "3");
        String d = hashMap.put("C", "4");

        System.out.println(a + " " + b + " " + c + " " + d);

        hashMap.forEach((k, v) -> System.out.println("KEY: '" + k + "' VALUE: '" + v + "' "));
    }
}
// end::HashMapExample2[]
// tag::HashMapExample2Result[]
// null null null 3
// KEY: 'A' VALUE: '1'
// KEY: 'B' VALUE: '2'
// KEY: 'C' VALUE: '4'
// end::HashMapExample2Result[]
