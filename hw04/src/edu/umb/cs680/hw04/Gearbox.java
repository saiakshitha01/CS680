package edu.umb.cs680.hw04;

public class Gearbox {
    private State currentState;

    public Gearbox() {
        // Initialize with Gear 1 as the default state
        this.currentState = new Gear1();
    }

    public void gearUp() {
        // Delegate the gear change to the current state
        currentState.gearUp(this);
    }

    public void gearDown() {
        // Delegate the gear change to the current state
        currentState.gearDown(this);
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getCurrentState() {
        return currentState;
    }
}

