package nestedclasses.thermo;

import nestedclasses.thermo.Thermometer;
import nestedclasses.thermo.Thermostat;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ThermostatTest {
    @Test
    public void addThermometerShouldSetRoomsToHeat() {
        Thermostat thermostat = new Thermostat();
        Thermometer[] thermometers = {
                new Thermometer("room1", 25),
                new Thermometer("room2", 20),
                new Thermometer("room3", 22)
        };

        for (Thermometer thermometer : thermometers) {
            thermostat.addThermometer(thermometer);
        }
        assertThat(thermostat.getRoomsToHeat(), equalTo(Arrays.asList(new String[] {"room2", "room3"})));
    }

    @Test
    public void thermometerSetTemperatureShouldSetRoomsToHeat() {
        Thermostat thermostat = new Thermostat();
        Thermometer thermometer = new Thermometer("room1", 25);
        thermostat.addThermometer(thermometer);

        thermometer.setTemperature(22);
        assertThat(thermostat.getRoomsToHeat(), equalTo(Arrays.asList(new String[] {"room1"})));

        thermometer.setTemperature(23);
        assertThat(thermostat.getRoomsToHeat(), equalTo(Collections.emptyList()));
    }

}