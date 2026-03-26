package kovteba.example1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    @Test
    void addObserver_andSetTemperature_notifiesObserver() {
        WeatherStation station = new WeatherStation();
        List<Integer> updates = new ArrayList<>();
        Observer observer = updates::add;

        station.addObserver(observer);
        station.setTemperature(25);

        assertEquals(1, updates.size());
        assertEquals(25, updates.get(0));
    }

    @Test
    void removeObserver_doesNotReceiveUpdates() {
        WeatherStation station = new WeatherStation();
        List<Integer> updates = new ArrayList<>();
        Observer observer = updates::add;

        station.addObserver(observer);
        station.removeObserver(observer);
        station.setTemperature(30);

        assertTrue(updates.isEmpty());
    }

    @Test
    void multipleObservers_allNotified() {
        WeatherStation station = new WeatherStation();
        List<Integer> updates1 = new ArrayList<>();
        List<Integer> updates2 = new ArrayList<>();

        station.addObserver(updates1::add);
        station.addObserver(updates2::add);
        station.setTemperature(15);

        assertEquals(1, updates1.size());
        assertEquals(1, updates2.size());
    }

    @Test
    void setTemperature_multipleChanges_observerReceivesEach() {
        WeatherStation station = new WeatherStation();
        List<Integer> updates = new ArrayList<>();
        station.addObserver(updates::add);

        station.setTemperature(10);
        station.setTemperature(20);
        station.setTemperature(30);

        assertEquals(3, updates.size());
        assertEquals(List.of(10, 20, 30), updates);
    }

    @Test
    void phoneDisplay_update_doesNotThrow() {
        PhoneDisplay display = new PhoneDisplay();
        assertDoesNotThrow(() -> display.update(22));
    }

    @Test
    void windowDisplay_update_doesNotThrow() {
        WindowDisplay display = new WindowDisplay();
        assertDoesNotThrow(() -> display.update(18));
    }
}
