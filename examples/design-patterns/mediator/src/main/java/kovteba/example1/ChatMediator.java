package kovteba.example1;

// tag::ChatMediator[]
public interface ChatMediator {
    void sendMessage(String message, Participant sender);
    void addParticipant(Participant participant);
}
// end::ChatMediator[]
