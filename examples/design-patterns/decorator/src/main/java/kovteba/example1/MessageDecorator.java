package kovteba.example1;

// tag::MessageDecorator[]
/**
 * Базовий декоратор — реалізує той самий інтерфейс
 * і містить всередині компонент, який декорується.
 */
public abstract class MessageDecorator implements Message {

    protected final Message message; // композиція

    public MessageDecorator(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent(); // делегування
    }
}
// end::MessageDecorator[]
