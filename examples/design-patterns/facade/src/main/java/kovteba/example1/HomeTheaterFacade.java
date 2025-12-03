package kovteba.example1;

// tag::HomeTheaterFacade[]
public class HomeTheaterFacade {

    private final TV tv;
    private final SoundSystem soundSystem;
    private final StreamingService streamingService;

    public HomeTheaterFacade(TV tv, SoundSystem soundSystem, StreamingService streamingService) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.streamingService = streamingService;
    }

    public void watchMovie(String movie) {
        System.out.println("\nStarting movie...");

        tv.on();
        tv.setChannel(3);

        soundSystem.on();
        soundSystem.setVolume(25);

        streamingService.connect();
        streamingService.playMovie(movie);

        System.out.println("Movie is now playing!\n");
    }

    public void stopMovie() {
        System.out.println("\nStopping movie...");

        streamingService.disconnect();
        soundSystem.off();
        tv.off();

        System.out.println("Movie stopped.\n");
    }
}
// end::HomeTheaterFacade[]
