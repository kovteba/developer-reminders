package kovteba.example1;

// tag::ObserverDemo[]
public class ObserverDemo {

    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        Observer phone = new PhoneDisplay();
        Observer window = new WindowDisplay();

        station.addObserver(phone);
        station.addObserver(window);

        station.setTemperature(22);
        station.setTemperature(25);

        station.removeObserver(window);

        station.setTemperature(30);
    }
}
// end::ObserverDemo[]
/*
// tag::ObserverDemoResult[]
[WeatherStation] Temperature changed to: 22
[PhoneDisplay] New temperature: 22°C
[WindowDisplay] Temperature outside: 22°C
[WeatherStation] Temperature changed to: 25
[PhoneDisplay] New temperature: 25°C
[WindowDisplay] Temperature outside: 25°C
[WeatherStation] Temperature changed to: 30
[PhoneDisplay] New temperature: 30°C
// end::ObserverDemoResult[]
 */
