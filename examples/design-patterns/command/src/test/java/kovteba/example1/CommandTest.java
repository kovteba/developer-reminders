package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void lightOnCommand_execute_doesNotThrow() {
        Light light = new Light();
        Command cmd = new LightOnCommand(light);
        assertDoesNotThrow(cmd::execute);
    }

    @Test
    void lightOffCommand_execute_doesNotThrow() {
        Light light = new Light();
        Command cmd = new LightOffCommand(light);
        assertDoesNotThrow(cmd::execute);
    }

    @Test
    void remoteControl_pressButton_withLightOnCommand_doesNotThrow() {
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(new Light()));
        assertDoesNotThrow(remote::pressButton);
    }

    @Test
    void remoteControl_pressButton_withLightOffCommand_doesNotThrow() {
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOffCommand(new Light()));
        assertDoesNotThrow(remote::pressButton);
    }

    @Test
    void remoteControl_pressButton_withoutCommand_doesNotThrow() {
        RemoteControl remote = new RemoteControl();
        assertDoesNotThrow(remote::pressButton);
    }

    @Test
    void remoteControl_switchCommands_bothExecute() {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        assertDoesNotThrow(remote::pressButton);

        remote.setCommand(new LightOffCommand(light));
        assertDoesNotThrow(remote::pressButton);
    }
}
