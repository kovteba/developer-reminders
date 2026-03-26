package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    @Test
    void paymentContext_withCreditCard_doesNotThrow() {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment("4111111111111111"));
        assertDoesNotThrow(() -> context.processPayment(100.0));
    }

    @Test
    void paymentContext_withPaypal_doesNotThrow() {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new PaypalPayment("user@example.com"));
        assertDoesNotThrow(() -> context.processPayment(50.0));
    }

    @Test
    void paymentContext_withoutStrategy_throwsIllegalState() {
        PaymentContext context = new PaymentContext();
        assertThrows(IllegalStateException.class, () -> context.processPayment(75.0));
    }

    @Test
    void paymentContext_changeStrategy_usesNewStrategy() {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment("1234"));
        assertDoesNotThrow(() -> context.processPayment(10.0));

        context.setStrategy(new PaypalPayment("other@example.com"));
        assertDoesNotThrow(() -> context.processPayment(20.0));
    }

    @Test
    void creditCardPayment_pay_doesNotThrow() {
        PaymentStrategy strategy = new CreditCardPayment("9999");
        assertDoesNotThrow(() -> strategy.pay(200.0));
    }

    @Test
    void paypalPayment_pay_doesNotThrow() {
        PaymentStrategy strategy = new PaypalPayment("test@paypal.com");
        assertDoesNotThrow(() -> strategy.pay(300.0));
    }
}
