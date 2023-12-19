package edu.umb.cs680.hw11;

import java.util.List;

public class Cosine implements DistanceMetric {
    public double distance(List<Double> p1, List<Double> p2) {
        // Error handling if p1.size() != p2.size()
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Points must be of the same dimension.");
        }
        
        double dotProduct = 0.0;
        double normP1 = 0.0;
        double normP2 = 0.0;
        for (int i = 0; i < p1.size(); i++) {
            dotProduct += p1.get(i) * p2.get(i);
            normP1 += Math.pow(p1.get(i), 2);
            normP2 += Math.pow(p2.get(i), 2);
        }

        double cosineSimilarity = Math.sqrt((dotProduct*dotProduct) / (normP1 * normP2));

		return 1 - cosineSimilarity;
    }
}
