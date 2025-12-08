package kovteba.example1;

// tag::WeatherStation[]
import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int newTemperature) {
        System.out.println("[WeatherStation] Temperature changed to: " + newTemperature);
        this.temperature = newTemperature;
        notifyObservers();
    }
}
// end::WeatherStation[]
