package kovteba.example1;

// tag::PauseState[]
public class PauseState implements State {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming playback.");
        player.setState(new PlayState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Already paused.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Stopping from pause.");
        player.setState(new StopState());
    }
}
// end::PauseState[]
