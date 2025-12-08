package kovteba.example1;

// tag::PhoneDisplay[]
public class PhoneDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("[PhoneDisplay] New temperature: " + temperature + "°C");
    }
}
// end::PhoneDisplay[]
