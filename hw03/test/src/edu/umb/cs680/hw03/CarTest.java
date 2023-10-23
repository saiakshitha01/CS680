package edu.umb.cs680.hw03;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    public Car setUp() {
        return new Car("Model X", "Tesla", 5000, 75000.0f, 2020);
    }

    @Test
    public void testGetModel() {
        assertEquals("Model X", setUp().getModel());
    }

    @Test
    public void testGetMake() {
        assertEquals("Tesla", setUp().getMake());
    }

    @Test
    public void testGetMileage() {
        assertEquals(5000, setUp().getMileage());
    }

    @Test
    public void testGetPrice() {
        assertEquals(75000.0f, setUp().getPrice(), 0.001);
    }

    @Test
    public void testGetYear() {
        assertEquals(2020, setUp().getYear());
    }

    @Test
    public void testCarToStringArray() {
        String[] expected = {"Model X", "Tesla", "2020"};
        String[] result = carToStringArray(setUp());
        assertArrayEquals(expected, result);
    }

    // Private method to convert a Car object to a String array
    private String[] carToStringArray(Car car) {
        String[] carInfo = new String[3];
        carInfo[0] = car.getModel();
        carInfo[1] = car.getMake();
        carInfo[2] = Integer.toString(car.getYear());
        return carInfo;
    }
}

