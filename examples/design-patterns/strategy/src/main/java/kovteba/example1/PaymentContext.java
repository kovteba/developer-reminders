package kovteba.example1;

// tag::PaymentContext[]
public class PaymentContext {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set!");
        }
        strategy.pay(amount);
    }
}
// end::PaymentContext[]
