package edu.umb.cs680.hw04;

// Gear3 class implementing the State interface
public class Gear3 implements State {
    @Override
    public void gearUp(Gearbox gearbox) {
        System.out.println("Shifting from Gear 3 to Gear 4");
        gearbox.setState(new Gear4());
    }

    @Override
    public void gearDown(Gearbox gearbox) {
        System.out.println("Shifting from Gear 3 to Gear 2");
        gearbox.setState(new Gear2());
    }
}