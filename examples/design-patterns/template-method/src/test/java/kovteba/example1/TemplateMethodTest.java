package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMethodTest {

    @Test
    void coffee_prepareBeverage_doesNotThrow() {
        Beverage coffee = new Coffee();
        assertDoesNotThrow(coffee::prepareBeverage);
    }

    @Test
    void tea_prepareBeverage_doesNotThrow() {
        Beverage tea = new Tea();
        assertDoesNotThrow(tea::prepareBeverage);
    }

    @Test
    void teaWithNoCondiments_prepareBeverage_doesNotThrow() {
        Beverage tea = new Tea() {
            @Override
            protected boolean shouldAddCondiments() {
                return false;
            }
        };
        assertDoesNotThrow(tea::prepareBeverage);
    }

    @Test
    void coffeeWithNoCondiments_prepareBeverage_doesNotThrow() {
        Beverage coffee = new Coffee() {
            @Override
            protected boolean shouldAddCondiments() {
                return false;
            }
        };
        assertDoesNotThrow(coffee::prepareBeverage);
    }
}
