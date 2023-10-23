package edu.umb.cs680.hw04;

public class Gear2 implements State {
    @Override
    public void gearUp(Gearbox gearbox) {
        System.out.println("Shifting from Gear 2 to Gear 3");
        gearbox.setState(new Gear3());
    }

    @Override
    public void gearDown(Gearbox gearbox) {
        System.out.println("Shifting from Gear 2 to Gear 1");
        gearbox.setState(new Gear1());
    }
}
