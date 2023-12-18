package edu.umb.cs680.hw12;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        return Float.compare(car1.getPrice(), car2.getPrice());
    }
}

