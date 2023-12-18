package edu.umb.cs680.hw06;

import java.util.LinkedList;
import java.util.List;

public class StepCounter {

    private LinkedList<StepCountObserver> observers = new LinkedList<>();
	
	public void addObserver(StepCountObserver o) {
		observers.add(o);
	}

	public void clearObservers() {
		observers.clear();
		
	}
	
	public List<StepCountObserver> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
	}
	
	public void removeObserver(StepCountObserver o) {
		observers.remove(o);
	}

	public void notifyObservers(StepCount event) {
		observers.forEach( observer -> observer.updateStepCount(event));
	}
	
}
