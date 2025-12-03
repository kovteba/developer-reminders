package kovteba.example1;

// tag::TV[]
public class TV {
    public void on() {
        System.out.println("TV: turning ON");
    }

    public void off() {
        System.out.println("TV: turning OFF");
    }

    public void setChannel(int channel) {
        System.out.println("TV: switching to channel " + channel);
    }
}
// end::TV[]
