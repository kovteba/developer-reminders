package kovteba.example1;

// tag::StreamingService[]
public class StreamingService {
    public void connect() {
        System.out.println("StreamingService: connecting to streaming service");
    }

    public void disconnect() {
        System.out.println("StreamingService: disconnecting");
    }

    public void playMovie(String movie) {
        System.out.println("StreamingService: playing movie \"" + movie + "\"");
    }
}
// end::StreamingService[]
