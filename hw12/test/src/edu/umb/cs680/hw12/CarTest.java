package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarTest {

    @Test
    public void testYearComparator() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Model1", "Make1", 10000, 20000, 2015));
        cars.add(new Car("Model2", "Make2", 15000, 25000, 2018));
        cars.add(new Car("Model3", "Make3", 20000, 30000, 2017));

        List<Car> expectedOrder = List.of(cars.get(1), cars.get(2), cars.get(0));
        Collections.sort(cars, new YearComparator());
        assertIterableEquals(expectedOrder, cars);
    }

    @Test
    public void testMileageComparator() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Model1", "Make1", 10000, 20000, 2015));
        cars.add(new Car("Model2", "Make2", 15000, 25000, 2018));
        cars.add(new Car("Model3", "Make3", 20000, 30000, 2017));

        List<Car> expectedOrder = List.of(cars.get(0), cars.get(1), cars.get(2));
        Collections.sort(cars, new MileageComparator());
        assertIterableEquals(expectedOrder, cars);
    }

    @Test
    public void testPriceComparator() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Model1", "Make1", 10000, 20000, 2015));
        cars.add(new Car("Model2", "Make2", 15000, 25000, 2018));
        cars.add(new Car("Model3", "Make3", 20000, 30000, 2017));

        List<Car> expectedOrder = List.of(cars.get(0), cars.get(1), cars.get(2));
        Collections.sort(cars, new PriceComparator());
        assertIterableEquals(expectedOrder, cars);
    }

    @Test
    public void testParetoComparator() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Model1", "Make1", 10000, 20000f, 2018));
        cars.add(new Car("Model2", "Make2", 15000, 25000f, 2017));
        cars.add(new Car("Model3", "Make3", 20000, 30000f, 2015));

        // Set domination counts based on Pareto dominance criteria
        for (Car car1 : cars) {
            int dominationCount = 0;
            for (Car car2 : cars) {
                if (car1 != car2 && isDominated(car2, car1)) {
                    dominationCount++;
                }
            }
            car1.setDominationCount(dominationCount);
        }

        List<Car> expectedOrder = List.of(cars.get(0), cars.get(1), cars.get(2)); // Expected order after sorting
        Collections.sort(cars, new ParetoComparator());
        assertIterableEquals(expectedOrder, cars);
    }

    private boolean isDominated(Car car1, Car car2) {
        // Year: newer is better, Price: lower is better, Mileage: lower is better
        boolean yearBetterOrEqual = car1.getYear() >= car2.getYear();
        boolean priceBetterOrEqual = car1.getPrice() <= car2.getPrice();
        boolean mileageBetterOrEqual = car1.getMileage() <= car2.getMileage();

        boolean atLeastOneSuperior = car1.getYear() > car2.getYear() || car1.getPrice() < car2.getPrice() || car1.getMileage() < car2.getMileage();

        return yearBetterOrEqual && priceBetterOrEqual && mileageBetterOrEqual && atLeastOneSuperior;
    }

}
