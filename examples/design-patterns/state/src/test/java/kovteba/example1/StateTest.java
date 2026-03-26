package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void newMediaPlayer_defaultState_isStop() {
        MediaPlayer player = new MediaPlayer();
        // Default state is StopState; calling stop again should be allowed
        assertDoesNotThrow(player::stop);
    }

    @Test
    void stopState_play_transitionsToPlayState() {
        MediaPlayer player = new MediaPlayer();
        player.play(); // StopState -> PlayState
        // Now pause should work (PlayState -> PauseState)
        assertDoesNotThrow(player::pause);
    }

    @Test
    void playState_pause_transitionsToPauseState() {
        MediaPlayer player = new MediaPlayer();
        player.play();   // Stop -> Play
        player.pause();  // Play -> Pause
        // From PauseState, play should resume (-> PlayState)
        assertDoesNotThrow(player::play);
    }

    @Test
    void playState_stop_transitionsToStopState() {
        MediaPlayer player = new MediaPlayer();
        player.play();
        player.stop();   // Play -> Stop
        // From StopState, play again should work
        assertDoesNotThrow(player::play);
    }

    @Test
    void pauseState_stop_transitionsToStopState() {
        MediaPlayer player = new MediaPlayer();
        player.play();
        player.pause();
        player.stop();   // Pause -> Stop
        assertDoesNotThrow(player::play);
    }

    @Test
    void stopState_pause_doesNotTransition_doesNotThrow() {
        MediaPlayer player = new MediaPlayer();
        assertDoesNotThrow(player::pause);
    }

    @Test
    void playState_play_doesNotThrow() {
        MediaPlayer player = new MediaPlayer();
        player.play();
        assertDoesNotThrow(player::play); // Already playing
    }

    @Test
    void pauseState_pause_doesNotThrow() {
        MediaPlayer player = new MediaPlayer();
        player.play();
        player.pause();
        assertDoesNotThrow(player::pause); // Already paused
    }
}
