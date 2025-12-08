package kovteba.example1;

// tag::MediaPlayer[]
public class MediaPlayer {

    private State state;

    public MediaPlayer() {
        this.state = new StopState(); // default state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }
}
// end::MediaPlayer[]
