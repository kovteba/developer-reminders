package kovteba.java17.sealedclass.sealedclass3;

// tag::Expression[]
public sealed interface Expression permits Constant, Addition, Multiplication {}

record Constant(double value) implements Expression {}
record Addition(Expression left, Expression right) implements Expression {}
record Multiplication(Expression left, Expression right) implements Expression {}
// end::Expression[]
