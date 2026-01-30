package kovteba.java17.sealedclass.sealedclass1;

// tag::Transport[]
public sealed class Transport
        permits Car, Bike, Boat {
    // Загальна логіка
}
// end::Transport[]
