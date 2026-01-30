package kovteba.java17.sealedclass.sealedclass5.beforejava17;

// tag::BeforeJava17Demo[]
public class BeforeJava17Demo {
    public static void main(String[] args) {

        BeforeJava17Demo demo = new BeforeJava17Demo();
        demo.process(new Cash());
        demo.process(new Card("1234-5678-9876-5432"));
    }

    public void process(Payment p) {
        if (p instanceof Cash) {
            System.out.println("Обробка готівки");
        } else if (p instanceof Card) {
            Card card = (Card) p; // Потрібне явне приведення типів
            System.out.println("Обробка карти: " + card.number);
        } else {
            // Ми змушені писати цей блок, бо Java не знає, чи є інші типи
            throw new IllegalArgumentException("Невідомий тип платежу");
        }
    }
}
// end::BeforeJava17Demo[]
