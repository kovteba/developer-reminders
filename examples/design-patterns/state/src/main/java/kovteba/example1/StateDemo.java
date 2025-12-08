package kovteba.example1;

// tag::StateDemo[]
public class StateDemo {
    public static void main(String[] args) {

        MediaPlayer player = new MediaPlayer();

        player.play();   // Starting playback.
        player.pause();  // Pausing playback.
        player.play();   // Resuming playback.
        player.stop();   // Stopping playback.
        player.pause();  // Cannot pause. Player is stopped.
    }
}
// end::StateDemo[]
/*
// tag::StateDemoResult[]
Starting playback.
Pausing playback.
Resuming playback.
Stopping playback.
Cannot pause. Player is stopped.
// end::StateDemoResult[]
 */
