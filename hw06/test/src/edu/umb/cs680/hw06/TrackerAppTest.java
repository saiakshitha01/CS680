package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrackerAppTest {

    private TrackerApp trackerApp;
    private Location mockLocation;
    private StepCount mockStepCount;

    @BeforeEach
    void setUp() {
        trackerApp = new TrackerApp();
        mockLocation = new Location("123 Main St");
        mockStepCount = new StepCount(1000); // Assuming StepCount class has a constructor that takes daily steps
    }

    @Test
    void updateLocation_ShouldUpdateLocationHistory() {
        trackerApp.updateLocation(mockLocation);
        assertEquals("123 Main St", trackerApp.latestLocationAddress());
    }

    @Test
    void updateStepCount_ShouldUpdateTotalSteps() {
        trackerApp.updateStepCount(mockStepCount);
        assertEquals(1000, trackerApp.getTotalSteps());
    }

    @Test
    void multipleUpdateStepCount_ShouldAccumulateTotalSteps() {
        trackerApp.updateStepCount(mockStepCount); // 1000 steps
        trackerApp.updateStepCount(new StepCount(500)); // 500 more steps
        assertEquals(1500, trackerApp.getTotalSteps());
    }
}

