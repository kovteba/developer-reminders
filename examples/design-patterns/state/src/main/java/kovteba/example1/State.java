package kovteba.example1;

// tag::State[]
public interface State {
    void play(MediaPlayer player);
    void pause(MediaPlayer player);
    void stop(MediaPlayer player);
}
// end::State[]
