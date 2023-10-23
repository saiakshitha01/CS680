package edu.umb.cs680.hw04;

// Gear5 class implementing the State interface
public class Gear5 implements State {
    @Override
    public void gearUp(Gearbox gearbox) {
        System.out.println("Already in top gear (Gear 5)");
    }

    @Override
    public void gearDown(Gearbox gearbox) {
        System.out.println("Shifting from Gear 5 to Gear 4");
        gearbox.setState(new Gear4());
    }
}
