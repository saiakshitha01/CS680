package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationSensorTest {

    private LocationSensor sensor;
    private TrackerApp observer1;

    @BeforeEach
    void setUp() {
        sensor = new LocationSensor();
        observer1 = new TrackerApp();
    }

    @Test
    void addObserver_ShouldAddObserver() {
        sensor.addObserver(observer1);
        assertEquals(1, sensor.countObservers());
    }

    @Test
    void removeObserver_ShouldRemoveObserver() {
        sensor.addObserver(observer1);
        sensor.removeObserver(observer1);
        assertEquals(0, sensor.countObservers());
    }

    @Test
    void clearObservers_ShouldClearAllObservers() {
        sensor.addObserver(observer1);
        sensor.clearObservers();
        assertEquals(0, sensor.countObservers());
    }

    @Test
    void notifyObservers_ShouldNotifyAllObservers() {
        sensor.addObserver(observer1);
        Location mockLocation = new Location("asdassd");
        sensor.notifyObservers(mockLocation);

        assertEquals(mockLocation.getAddress(), observer1.latestLocationAddress());
    }
}