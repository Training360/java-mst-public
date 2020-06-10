package nestedclasses.thermo;

public class Thermometer {

    private String room;
    private int temperature;
    private ThermometerObserver observer;

    public Thermometer(String room, int temperature) {
        this.room = room;
        this.temperature = temperature;
    }

    public void setTemperature(int temperature) {
        if (this.temperature != temperature) {
            this.temperature = temperature;
            onTemperatureChanged();
        }
    }

    public void onTemperatureChanged() {
        if (observer != null) {
            observer.handleTemperatureChange(temperature, room);
        }
    }

    public void setThermometerObserver(ThermometerObserver observer) {
        this.observer = observer;
        onTemperatureChanged();
    }

}
