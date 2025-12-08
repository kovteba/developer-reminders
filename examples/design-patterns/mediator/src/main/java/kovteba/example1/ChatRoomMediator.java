package kovteba.example1;

import java.util.ArrayList;
import java.util.List;

// tag::ChatRoomMediator[]
public class ChatRoomMediator implements ChatMediator {

    private final List<Participant> participants = new ArrayList<>();

    @Override
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void sendMessage(String message, Participant sender) {
        for (Participant participant : participants) {
            if (participant != sender) {
                participant.receive(message, sender.getName());
            }
        }
    }
}
// end::ChatRoomMediator[]
