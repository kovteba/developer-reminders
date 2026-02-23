package kovteba.java17.sealedclass.sealedclass5.afterjava17error1;

// tag::Payment[]
sealed interface Payment permits Cash, Card {}

record Cash() implements Payment {}
record Card(String number) implements Payment {}
//record Crypto(String number) implements Payment {} // 'Crypto' is not allowed in the sealed hierarchy.
// end::Payment[]
