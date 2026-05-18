package kovteba.collectionframework.map.hashmap;

import java.util.HashMap;

// tag::HashMapExample3[]
public class HashMapExample3 {
    public static void main(String[] args) {

        HashMap<Key, String> hashMap = new HashMap<>();

        Key aKey = new Key("aKey", "aValue");

        hashMap.put(aKey, "value1");

        System.out.println(hashMap.get(aKey));
        aKey.setKey("aKey1");
        System.out.println(hashMap.get(aKey));
    }

    static class Key {

        private String key;
        private String value;

        public Key(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(String value) {
            this.value = value;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Key key1 = (Key) o;
//
//            return key.equals(key1.key);
//        }
//
//        @Override
//        public int hashCode() {
//            return key.hashCode();
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key1 = (Key) o;

            if (!key.equals(key1.key)) return false;
            return value.equals(key1.value);
        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }
    }
}
// end::HashMapExample3[]
// tag::HashMapExample3Result[]
// value1
// null
// end::HashMapExample3Result[]
