package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GearboxTest {

    @Test
    public void testShiftUpFromGear1ToGear2() {
        Gearbox gearbox = new Gearbox();
        gearbox.gearUp(); // Shift from Gear 1 to Gear 2
        assertEquals("Gear2", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftUpFromGear2ToGear3() {
        Gearbox gearbox = new Gearbox();
        gearbox.gearUp(); // Shift from Gear 1 to Gear 2
        gearbox.gearUp(); // Shift from Gear 2 to Gear 3
        assertEquals("Gear3", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftUpFromGear3ToGear4() {
        Gearbox gearbox = new Gearbox();
        gearbox.gearUp(); // Shift from Gear 1 to Gear 2
        gearbox.gearUp(); // Shift from Gear 2 to Gear 3
        gearbox.gearUp(); // Shift from Gear 3 to Gear 4
        assertEquals("Gear4", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftUpFromGear4ToGear5() {
        Gearbox gearbox = new Gearbox();
        gearbox.gearUp(); // Shift from Gear 1 to Gear 2
        gearbox.gearUp(); // Shift from Gear 2 to Gear 3
        gearbox.gearUp(); // Shift from Gear 3 to Gear 4
        gearbox.gearUp(); // Shift from Gear 4 to Gear 5
        assertEquals("Gear5", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftDownFromGear5ToGear4() {
        Gearbox gearbox = new Gearbox();
        // Set the initial gear to Gear 5
        for (int i = 0; i < 4; i++) {
            gearbox.gearUp(); // Shift to Gear 5
        }

        gearbox.gearDown(); // Shift from Gear 5 to Gear 4
        assertEquals("Gear4", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftDownFromGear4ToGear3() {
        Gearbox gearbox = new Gearbox();
        // Set the initial gear to Gear 4
        for (int i = 0; i < 3; i++) {
            gearbox.gearUp(); // Shift to Gear 4
        }

        gearbox.gearDown(); // Shift from Gear 4 to Gear 3
        assertEquals("Gear3", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftDownFromGear3ToGear2() {
        Gearbox gearbox = new Gearbox();
        // Set the initial gear to Gear 3
        for (int i = 0; i < 2; i++) {
            gearbox.gearUp(); // Shift to Gear 3
        }

        gearbox.gearDown(); // Shift from Gear 3 to Gear 2
        assertEquals("Gear2", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftDownFromGear2ToGear1() {
        Gearbox gearbox = new Gearbox();
        // Set the initial gear to Gear 2
        gearbox.gearUp(); // Shift to Gear 2

        gearbox.gearDown(); // Shift from Gear 2 to Gear 1
        assertEquals("Gear1", gearbox.getCurrentState().getClass().getSimpleName());
    }

    @Test
    public void testShiftDownFromGear1ToGear1() {
        Gearbox gearbox = new Gearbox();
        // Attempt to shift down from the lowest gear (Gear 1)
        gearbox.gearDown(); // Should remain in Gear 1
        assertEquals("Gear1", gearbox.getCurrentState().getClass().getSimpleName());
    }
}
