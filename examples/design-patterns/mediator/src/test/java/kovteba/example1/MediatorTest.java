package kovteba.example1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MediatorTest {

    @Test
    void sendMessage_deliveredToOtherParticipants() {
        ChatRoomMediator mediator = new ChatRoomMediator();
        List<String> received = new ArrayList<>();

        UserParticipant alice = new UserParticipant(mediator, "Alice");
        UserParticipant bob = new UserParticipant(mediator, "Bob") {
            @Override
            public void receive(String message, String from) {
                received.add(from + ":" + message);
            }
        };

        mediator.addParticipant(alice);
        mediator.addParticipant(bob);

        alice.send("Hello");
        assertEquals(1, received.size());
        assertEquals("Alice:Hello", received.get(0));
    }

    @Test
    void sendMessage_notDeliveredToSender() {
        ChatRoomMediator mediator = new ChatRoomMediator();
        List<String> received = new ArrayList<>();

        UserParticipant alice = new UserParticipant(mediator, "Alice") {
            @Override
            public void receive(String message, String from) {
                received.add(message);
            }
        };
        UserParticipant bob = new UserParticipant(mediator, "Bob");

        mediator.addParticipant(alice);
        mediator.addParticipant(bob);

        alice.send("Test");
        assertTrue(received.isEmpty(), "Sender should not receive its own message");
    }

    @Test
    void getName_returnsCorrectName() {
        ChatRoomMediator mediator = new ChatRoomMediator();
        UserParticipant user = new UserParticipant(mediator, "Carol");
        assertEquals("Carol", user.getName());
    }

    @Test
    void send_withNoOtherParticipants_doesNotThrow() {
        ChatRoomMediator mediator = new ChatRoomMediator();
        UserParticipant solo = new UserParticipant(mediator, "Solo");
        mediator.addParticipant(solo);
        assertDoesNotThrow(() -> solo.send("Hello?"));
    }
}
