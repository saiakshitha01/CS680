package edu.umb.cs680.hw04;

public interface State {
    void gearUp(Gearbox gearbox);

    void gearDown(Gearbox gearbox);
}
