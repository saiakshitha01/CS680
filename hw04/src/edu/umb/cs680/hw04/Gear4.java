package edu.umb.cs680.hw04;

// Gear4 class implementing the State interface
public class Gear4 implements State {
    @Override
    public void gearUp(Gearbox gearbox) {
        System.out.println("Shifting from Gear 4 to Gear 5");
        gearbox.setState(new Gear5());
    }

    @Override
    public void gearDown(Gearbox gearbox) {
        System.out.println("Shifting from Gear 4 to Gear 3");
        gearbox.setState(new Gear3());
    }
}