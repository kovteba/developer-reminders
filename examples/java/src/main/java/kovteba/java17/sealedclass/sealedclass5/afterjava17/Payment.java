package kovteba.java17.sealedclass.sealedclass5.afterjava17;

// tag::Payment[]
sealed interface Payment permits Cash, Card {}

record Cash() implements Payment {}
record Card(String number) implements Payment {}
// end::Payment[]
