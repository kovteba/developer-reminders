package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {

    @Test
    void watchMovie_doesNotThrow() {
        HomeTheaterFacade facade = new HomeTheaterFacade(new TV(), new SoundSystem(), new StreamingService());
        assertDoesNotThrow(() -> facade.watchMovie("Inception"));
    }

    @Test
    void stopMovie_doesNotThrow() {
        HomeTheaterFacade facade = new HomeTheaterFacade(new TV(), new SoundSystem(), new StreamingService());
        assertDoesNotThrow(facade::stopMovie);
    }

    @Test
    void watchAndStop_doesNotThrow() {
        HomeTheaterFacade facade = new HomeTheaterFacade(new TV(), new SoundSystem(), new StreamingService());
        assertDoesNotThrow(() -> {
            facade.watchMovie("Matrix");
            facade.stopMovie();
        });
    }
}
