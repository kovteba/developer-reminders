package kovteba.example1;

// tag::StrategyDemo[]
public class StrategyDemo {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment("1111-2222-3333-4444"));
        context.processPayment(150.0);

        context.setStrategy(new PaypalPayment("user@example.com"));
        context.processPayment(99.9);
    }
}
// end::StrategyDemo[]
/*
// tag::StrategyDemoResult[]
Paid 150.0 using Credit Card: 1111-2222-3333-4444
Paid 99.9 using PayPal account: user@example.com
// end::StrategyDemoResult[]
 */