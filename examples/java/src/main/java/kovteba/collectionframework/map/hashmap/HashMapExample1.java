package kovteba.collectionframework.map.hashmap;

import java.util.HashMap;

// tag::HashMapExample1[]
public class HashMapExample1 {
    public static void main(String[] args) {

        HashMap<int[], String> intArrayHashMap = new HashMap<>();

        int[] a1 = {1, 2, 3};
        int[] same = {1, 2, 3};
        int[] b1 = {1, 2, 3};

        intArrayHashMap.put(a1, "a");
        intArrayHashMap.put(b1, "b");

        String a1Key = intArrayHashMap.get(a1);
        String sameKey = intArrayHashMap.get(same);
        System.out.println("Finding value using a1 key: '" + a1Key + "' and using same key: '" + sameKey + "'");
    }
}
// end::HashMapExample1[]
// tag::HashMapExample1Result[]
// Finding value using a1 key: 'a' and using same key: 'null'
// end::HashMapExample1Result[]
