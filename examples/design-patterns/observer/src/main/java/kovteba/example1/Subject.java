package kovteba.example1;

// tag::Subject[]
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
// end::Subject[]
