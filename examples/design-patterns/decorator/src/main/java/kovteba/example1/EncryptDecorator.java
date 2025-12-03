package kovteba.example1;

// tag::EncryptDecorator[]
/**
 * Декоратор, що "шифрує" повідомлення (спрощено — реверс тексту).
 */
public class EncryptDecorator extends MessageDecorator {

    public EncryptDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        String original = super.getContent();
        return new StringBuilder(original).reverse().toString();
    }
}
// end::EncryptDecorator[]
