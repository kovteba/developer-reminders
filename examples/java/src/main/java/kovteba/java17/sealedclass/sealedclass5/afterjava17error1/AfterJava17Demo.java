package kovteba.java17.sealedclass.sealedclass5.afterjava17error1;

// tag::AfterJava17Demo[]
public class AfterJava17Demo {
    public static void main(String[] args) {
        AfterJava17Demo demo = new AfterJava17Demo();
        demo.process(new Cash());
        demo.process(new Card("1234-5678-9876-5432"));
    }

    public void process(Payment p) {
        // 2. Використовуємо switch як вираз (Expression)
        switch (p) {
            case Cash c -> System.out.println("Обробка готівки");
            case Card(String n) -> System.out.println("Обробка карти: " + n);
            // Блок default або else НЕ ПОТРІБЕН!
            // Якщо ви додасте новий тип у permits, цей код не скомпілюється,
            // поки ви не додасте новий case.
        }
    }
}
// end::AfterJava17Demo[]
