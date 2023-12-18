package edu.umb.cs680.hw06;

import java.util.LinkedList;
import java.util.List;

public class LocationSensor {

    private LinkedList<LocationObserver> observers = new LinkedList<>();
	
	public void addObserver(LocationObserver o) {
		observers.add(o);
	}

	public void clearObservers() {
		observers.clear();
	}
	
	public List<LocationObserver> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
	}
	
	public void removeObserver(LocationObserver o) {
		observers.remove(o);
	}

	public void notifyObservers(Location event) {
		observers.forEach( observer -> observer.updateLocation(event));
	}
    
}
