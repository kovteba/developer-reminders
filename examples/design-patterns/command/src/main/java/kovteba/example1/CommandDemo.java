package kovteba.example1;

// tag::CommandDemo[]
public class CommandDemo {
    public static void main(String[] args) {

        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();  // 💡 Light is ON

        remote.setCommand(lightOff);
        remote.pressButton();  // 💡 Light is OFF
    }
}
// end::CommandDemo[]
// tag::CommandDemoResult[]
//💡 Light is ON
//💡 Light is OFF
// end::CommandDemoResult[]
