package kovteba.example1;

// tag::StopState[]
public class StopState implements State {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Starting playback.");
        player.setState(new PlayState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Cannot pause. Player is stopped.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Already stopped.");
    }
}
// end::StopState[]
