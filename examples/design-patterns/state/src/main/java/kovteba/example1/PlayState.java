package kovteba.example1;

// tag::PlayState[]
public class PlayState implements State {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Already playing.");
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Pausing playback.");
        player.setState(new PauseState());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Stopping playback.");
        player.setState(new StopState());
    }
}
// end::PlayState[]
