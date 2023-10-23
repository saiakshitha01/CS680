package edu.umb.cs680.hw05;

public interface Observer<T> {
    public abstract void update(Observable<T> observer ,T event);
}
