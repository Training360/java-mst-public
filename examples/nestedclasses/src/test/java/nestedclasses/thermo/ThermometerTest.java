package nestedclasses.thermo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ThermometerTest {

    private static class TestObserver implements ThermometerObserver {
        private int temperature;
        private String room;

        @Override
        public void handleTemperatureChange(int temp, String room) {
            this.temperature = temp;
            this.room = room;
        }

        public int getTemperature() {
            return temperature;
        }

        public String getRoom() {
            return room;
        }
    }

    @Test
    public void setTemperatureShouldObserver() {
        Thermometer thermometer = new Thermometer("room1", 25);
        TestObserver observer = new TestObserver();
        thermometer.setThermometerObserver(observer);

        thermometer.setTemperature(22);
        assertThat(observer.getRoom(), equalTo("room1"));
        assertThat(observer.getTemperature(), equalTo(22));
    }

}