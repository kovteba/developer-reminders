package kovteba.example1;

// tag::FacadeDemo[]
public class FacadeDemo {
    public static void main(String[] args) {
        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        StreamingService streamingService = new StreamingService();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, soundSystem, streamingService);

        homeTheater.watchMovie("Inception");
        homeTheater.stopMovie();
    }
}
// end::FacadeDemo[]
