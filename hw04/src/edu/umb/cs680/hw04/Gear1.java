package edu.umb.cs680.hw04;

public class Gear1 implements State {
    @Override
    public void gearUp(Gearbox gearbox) {
        System.out.println("Shifting from Gear 1 to Gear 2");
        gearbox.setState(new Gear2());
    }

    @Override
    public void gearDown(Gearbox gearbox) {
        System.out.println("Already in the lowest gear (Gear 1)");
    }
}
