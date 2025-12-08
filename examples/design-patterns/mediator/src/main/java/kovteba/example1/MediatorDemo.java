package kovteba.example1;

// tag::MediatorDemo[]
public class MediatorDemo {

    public static void main(String[] args) {

        ChatMediator mediator = new ChatRoomMediator();

        Participant user1 = new UserParticipant(mediator, "Alice");
        Participant user2 = new UserParticipant(mediator, "Bob");
        Participant user3 = new UserParticipant(mediator, "Charlie");

        mediator.addParticipant(user1);
        mediator.addParticipant(user2);
        mediator.addParticipant(user3);

        user1.send("Hello everyone!");
        user3.send("Hi Alice!");
    }
}
// end::MediatorDemo[]
/*
// tag::MediatorDemoResult[]
Alice sends: Hello everyone!
Bob receives from Alice: Hello everyone!
Charlie receives from Alice: Hello everyone!
Charlie sends: Hi Alice!
Alice receives from Charlie: Hi Alice!
Bob receives from Charlie: Hi Alice!
// end::MediatorDemoResult[]
 */

