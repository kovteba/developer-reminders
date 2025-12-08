package kovteba.example1;

// tag::UserParticipant[]
public class UserParticipant extends Participant {

    public UserParticipant(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message, String from) {
        System.out.println(name + " receives from " + from + ": " + message);
    }
}
// end::UserParticipant[]
