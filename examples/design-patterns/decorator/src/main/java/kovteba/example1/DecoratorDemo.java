package kovteba.example1;

// tag::DecoratorDemo[]
public class DecoratorDemo {

    public static void main(String[] args) {

        // Базове повідомлення
        Message message = new SimpleMessage("Hello Dmytro!");

        // Додаємо логування
        message = new LogDecorator(message);

        // Додаємо "шифрування"
        message = new EncryptDecorator(message);

        System.out.println("Final output: " + message.getContent());
    }
}
// end::DecoratorDemo[]
