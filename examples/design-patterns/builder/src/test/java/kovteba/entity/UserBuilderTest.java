package kovteba.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserBuilderTest {

    @Test
    void build_withAllFields_containsAllValues() {
        User user = new User.Builder()
                .username("john")
                .email("john@example.com")
                .age(30)
                .address("123 Main St")
                .build();

        String result = user.toString();
        assertTrue(result.contains("john"));
        assertTrue(result.contains("john@example.com"));
        assertTrue(result.contains("30"));
        assertTrue(result.contains("123 Main St"));
    }

    @Test
    void build_withOnlyUsername_otherFieldsAreDefault() {
        User user = new User.Builder()
                .username("alice")
                .build();

        String result = user.toString();
        assertTrue(result.contains("alice"));
        assertTrue(result.contains("age=0"));
    }

    @Test
    void build_withNullFields_doesNotThrow() {
        assertDoesNotThrow(() -> new User.Builder()
                .username(null)
                .email(null)
                .build());
    }

    @Test
    void build_createsDistinctInstances() {
        User user1 = new User.Builder().username("a").build();
        User user2 = new User.Builder().username("b").build();
        assertNotSame(user1, user2);
        assertNotEquals(user1.toString(), user2.toString());
    }
}
