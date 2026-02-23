package kovteba.java17.sealedclass.sealedclass5.afterjava17error2;

// tag::Payment[]
sealed interface Payment permits Cash, Card, Crypto {}

record Cash() implements Payment {}
record Card(String number) implements Payment {}
record Crypto(String number) implements Payment {}
// end::Payment[]
