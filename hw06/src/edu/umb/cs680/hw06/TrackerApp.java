package edu.umb.cs680.hw06;

import java.util.LinkedList;

public class TrackerApp implements LocationObserver, StepCountObserver {

    private int totalSteps = 0;
    private LinkedList<Location> locationHistory = new LinkedList<Location>();

    @Override
    public void updateStepCount(StepCount sc) {
        System.out.println(sc.getDailySteps() + " added");
        totalSteps += sc.getDailySteps();
        System.out.println(totalSteps + " total steps");
    }
    
    @Override
    public void updateLocation(Location loc) {
        System.out.println(loc.getAddress() + " location updated");
        locationHistory.add(loc);
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public String latestLocationAddress() {
        return locationHistory.getLast().getAddress();
    }
       
}
