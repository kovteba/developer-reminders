package kovteba.aop1;

public class MessageWriter implements IMessageWriter {

    @Override
    public void writeMessage() {
        System.out.print("World");
    }
}
