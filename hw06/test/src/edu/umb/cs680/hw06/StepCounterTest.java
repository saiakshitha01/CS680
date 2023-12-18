package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StepCounterTest {

    private StepCounter stepCounter;
    private TrackerApp observer;

    @BeforeEach
    void setUp() {
        stepCounter = new StepCounter();
        observer = new TrackerApp();
    }

    @Test
    void addObserver_ShouldAddObserver() {
        stepCounter.addObserver(observer);
        assertEquals(1, stepCounter.countObservers());
    }

    @Test
    void removeObserver_ShouldRemoveObserver() {
        stepCounter.addObserver(observer);
        stepCounter.removeObserver(observer);
        assertEquals(0, stepCounter.countObservers());
    }

    @Test
    void clearObservers_ShouldClearAllObservers() {
        stepCounter.addObserver(observer);
        stepCounter.clearObservers();
        assertEquals(0, stepCounter.countObservers());
    }

    @Test
    void notifyObservers_ShouldNotifyAllObservers() {
        stepCounter.addObserver(observer);
        StepCount mockStepCount = new StepCount(100);
        stepCounter.notifyObservers(mockStepCount);

        assertEquals(100, observer.getTotalSteps());
    }
}