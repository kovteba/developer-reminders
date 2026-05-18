package kovteba.collectionframework.map.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class HashMapPutExample1 {
    public static void main(String[] args) {



        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};




        HashMap<Key, String> hashMap = new HashMap<>();

//        hashMap.put("aKey", "value1");
//        hashMap.put("aKey", "value2");

//        hashMap.put(null, "value2");
//        hashMap.put(null, "value2");

        Key aKey = new Key("aKey");
        Key bKey = new Key("bKey");

//        System.out.println(aKey.hashCode());
//        System.out.println(bKey.hashCode());


        String value = hashMap.put(aKey, "value1");
        String value1 = hashMap.put(aKey, "value2");
        String value2 = hashMap.put(aKey, "value3");
        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);
//        hashMap.put(bKey, "value2");


//        System.out.println(method(aKey));

//        97 = 01100001
//        &
//        15 = 00001111
//             00000001

//        String s = Integer.toBinaryString(97);
//        System.out.println(s);


//        System.out.println(method(aKey) & (16-1));

//        System.out.println(hashMap.get(bKey));

//        System.out.println(method(new Key("aKey")));
//        System.out.println(method(new Key("aKey")));

        String[] strings = new String[10];
        strings[0] = "a";





        System.out.println("SSSS " + hash(0));
    }

    static final int hash(Object key) {
        int h;

        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Key {
        private String key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key1 = (Key) o;

            return Objects.equals(key, key1.key);
        }

        @Override
        public int hashCode() {
            return key.charAt(0);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }
}
