package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DistanceTest {

    private List<List<Double>> createPoints() {
        List<List<Double>> points = new ArrayList<>();
        points.add(Arrays.asList(2.0, 3.0)); // Point 1
        points.add(Arrays.asList(5.0, 7.0)); // Point 2
        points.add(Arrays.asList(4.0, 1.0)); // Point 3
        return points;
    }

    @Test
    public void testDistanceWithEuclideanMetric() {
        List<List<Double>> points = createPoints();
        Double matrix = Distance.get(points.get(0), points.get(1), new Euclidean());
        
        assertEquals(5.0, matrix);
    }

    @Test
    public void testDistanceWithManhattanMetric() {
        List<List<Double>> points = createPoints();
        Double matrix = Distance.get(points.get(0), points.get(1), new Manhattan());
        
        assertEquals(7.0, matrix);
    }

    @Test
    public void testDistanceMatrixWithEuclideanMetric() {
        List<List<Double>> points = createPoints();
        List<List<Double>> matrix = Distance.matrix(points, new Euclidean());
        List<List<Double>> expected = List.of(
            List.of(0.0, 5.0, 2.8284271247461903),
            List.of(5.0, 0.0, 6.082762530298219),
            List.of(2.8284271247461903, 6.082762530298219, 0.0)
        );
        assertIterableEquals(expected, matrix);
    }

    @Test
    public void testDistanceMatrixWithManhattanMetric() {
        List<List<Double>> points = createPoints();
        List<List<Double>> matrix = Distance.matrix(points, new Manhattan());
        List<List<Double>> expected = List.of(
            List.of(0.0, 7.0, 4.0),
            List.of(7.0, 0.0, 7.0),
            List.of(4.0, 7.0, 0.0)
        );
        assertIterableEquals(expected, matrix);
    }

    @Test
    public void testDistanceWithCosineMetric() {
        List<List<Double>> points = createPoints();
        Double distance = Distance.get(points.get(0), points.get(1), new Cosine());
        
        double dotProduct = 2 * 5 + 3 * 7;
        double normP1 = Math.sqrt(2 * 2 + 3 * 3);
        double normP2 = Math.sqrt(5 * 5 + 7 * 7);
        double cosineSimilarity = dotProduct / (normP1 * normP2);
        double expected = 1 - cosineSimilarity;
        assertEquals(expected, distance);
    }

    @Test
    public void testDistanceWithCosineMetricForTwoSamePointsIsOneMinusRoot2() {
        List<List<Double>> points = createPoints();
        Double distance = Distance.get(List.of(2.0, 5.0), List.of(2.0, 5.0), new Cosine());
        Double expected = 0.0;
        assertEquals(expected, distance);
    }

    @Test
    public void testDistanceMatrixWithCosineMetric() {
        List<List<Double>> points = createPoints();
        List<List<Double>> matrix = Distance.matrix(points, new Cosine());
        Double expected = 0.0;

        assertEquals(3, matrix.size());
        assertEquals(3, matrix.get(0).size());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    assertEquals(expected, matrix.get(i).get(j));
                }
            }
        }
    }

    @Test
    public void testDistanceMatrixWithCosineMetric1000points() {
        List<Car> carArray =  new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1500; i++) {
            carArray.add(new Car("ewwefjn", "wefjnew", random.nextInt(10000), random.nextFloat(10000), random.nextInt(10000)));
        }

        List<List<Double>> points = new ArrayList<>();
        for (int i = 0; i < 1500; i++) {
            points.add(List.of((double)carArray.get(i).getMileage(), (double) carArray.get(i).getYear(), (double) carArray.get(i).getPrice()));
        }

        int dimensions = 3; // Assuming each point has 3 dimensions
        double[] means = new double[dimensions];
        double[] stdDevs = new double[dimensions];

        // Calculate means
        for (List<Double> point : points) {
            for (int i = 0; i < dimensions; i++) {
                means[i] += point.get(i);
            }
        }
        for (int i = 0; i < dimensions; i++) {
            means[i] /= points.size();
        }

        // Calculate standard deviations
        for (List<Double> point : points) {
            for (int i = 0; i < dimensions; i++) {
                stdDevs[i] += Math.pow(point.get(i) - means[i], 2);
            }
        }
        for (int i = 0; i < dimensions; i++) {
            stdDevs[i] = Math.sqrt(stdDevs[i] / points.size());
        }

        // Normalize points
        List<List<Double>> normalizedPoints = new ArrayList<>();
        for (List<Double> point : points) {
            List<Double> normalizedPoint = new ArrayList<>();
            for (int i = 0; i < dimensions; i++) {
                double z = (point.get(i) - means[i]) / stdDevs[i];
                normalizedPoint.add(z);
            }
            normalizedPoints.add(normalizedPoint);
        }
        
        List<List<Double>> matrix = Distance.matrix(normalizedPoints, new Cosine());

        for (int i = 0; i < 1500; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    assertEquals(0.0, matrix.get(i).get(j));
                }
            }
        }
        
    }

    @Test
    public void testDistanceMatrixWithManhattanMetric1000points() {
        List<Car> carArray =  new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1500; i++) {
            carArray.add(new Car("ewwefjn", "wefjnew", random.nextInt(10000), random.nextFloat(10000), random.nextInt(10000)));
        }

        List<List<Double>> points = new ArrayList<>();
        for (int i = 0; i < 1500; i++) {
            points.add(List.of((double)carArray.get(i).getMileage(), (double) carArray.get(i).getYear(), (double) carArray.get(i).getPrice()));
        }

        int dimensions = 3; // Assuming each point has 3 dimensions
        double[] means = new double[dimensions];
        double[] stdDevs = new double[dimensions];

        // Calculate means
        for (List<Double> point : points) {
            for (int i = 0; i < dimensions; i++) {
                means[i] += point.get(i);
            }
        }
        for (int i = 0; i < dimensions; i++) {
            means[i] /= points.size();
        }

        // Calculate standard deviations
        for (List<Double> point : points) {
            for (int i = 0; i < dimensions; i++) {
                stdDevs[i] += Math.pow(point.get(i) - means[i], 2);
            }
        }
        for (int i = 0; i < dimensions; i++) {
            stdDevs[i] = Math.sqrt(stdDevs[i] / points.size());
        }

        // Normalize points
        List<List<Double>> normalizedPoints = new ArrayList<>();
        for (List<Double> point : points) {
            List<Double> normalizedPoint = new ArrayList<>();
            for (int i = 0; i < dimensions; i++) {
                double z = (point.get(i) - means[i]) / stdDevs[i];
                normalizedPoint.add(z);
            }
            normalizedPoints.add(normalizedPoint);
        }
        
        List<List<Double>> matrix = Distance.matrix(normalizedPoints, new Manhattan());

        for (int i = 0; i < 1500; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    assertEquals(0.0, matrix.get(i).get(j));
                }
            }
        }
        
    }

    @Test
    public void testDistanceMatrixWithEuclideanMetric1000points() {
        List<Car> carArray =  new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1500; i++) {
            carArray.add(new Car("ewwefjn", "wefjnew", random.nextInt(10000), random.nextFloat(10000), random.nextInt(10000)));
        }

        List<List<Double>> points = new ArrayList<>();
        for (int i = 0; i < 1500; i++) {
            points.add(List.of((double)carArray.get(i).getMileage(), (double) carArray.get(i).getYear(), (double) carArray.get(i).getPrice()));
        }

        int dimensions = 3; // Assuming each point has 3 dimensions
        double[] means = new double[dimensions];
        double[] stdDevs = new double[dimensions];

        // Calculate means
        for (List<Double> point : points) {
            for (int i = 0; i < dimensions; i++) {
                means[i] += point.get(i);
            }
        }
        for (int i = 0; i < dimensions; i++) {
            means[i] /= points.size();
        }

        // Calculate standard deviations
        for (List<Double> point : points) {
            for (int i = 0; i < dimensions; i++) {
                stdDevs[i] += Math.pow(point.get(i) - means[i], 2);
            }
        }
        for (int i = 0; i < dimensions; i++) {
            stdDevs[i] = Math.sqrt(stdDevs[i] / points.size());
        }

        // Normalize points
        List<List<Double>> normalizedPoints = new ArrayList<>();
        for (List<Double> point : points) {
            List<Double> normalizedPoint = new ArrayList<>();
            for (int i = 0; i < dimensions; i++) {
                double z = (point.get(i) - means[i]) / stdDevs[i];
                normalizedPoint.add(z);
            }
            normalizedPoints.add(normalizedPoint);
        }
        
        List<List<Double>> matrix = Distance.matrix(normalizedPoints, new Euclidean());

        for (int i = 0; i < 1500; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    assertEquals(0.0, matrix.get(i).get(j));
                }
            }
        }
        
    }


}
