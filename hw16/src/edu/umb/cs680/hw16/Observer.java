package edu.umb.cs680.hw16;

public interface Observer<T> {
    public abstract void update(Observable<T> observer ,T event);
}
