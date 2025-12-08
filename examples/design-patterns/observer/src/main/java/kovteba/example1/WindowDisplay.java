package kovteba.example1;

// tag::WindowDisplay[]
public class WindowDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("[WindowDisplay] Temperature outside: " + temperature + "°C");
    }
}
// end::WindowDisplay[]
