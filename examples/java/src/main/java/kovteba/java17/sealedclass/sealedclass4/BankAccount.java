package kovteba.java17.sealedclass.sealedclass4;

// tag::BankAccount[]
public abstract sealed class BankAccount permits SavingsAccount, CheckingAccount {
    private String owner;
    // ...
}

non-sealed class SavingsAccount extends BankAccount {
    // ...
}
non-sealed class CheckingAccount extends BankAccount {
    // ...
}
// end::BankAccount[]
