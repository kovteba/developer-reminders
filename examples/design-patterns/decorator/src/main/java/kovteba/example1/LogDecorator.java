package kovteba.example1;

// tag::LogDecorator[]
/**
 * Логуючий декоратор — записує повідомлення в лог перед поверненням.
 */
public class LogDecorator extends MessageDecorator {

    public LogDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        System.out.println("[LOG]: " + content);
        return content;
    }
}
// end::LogDecorator[]
