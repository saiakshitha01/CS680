package edu.umb.cs680.hw01;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void testGeneratePrimesFrom1To12() {
        PrimeGenerator generator = new PrimeGenerator(1, 12);
        generator.generatePrimes();
        LinkedList<Long> primes = generator.getPrimes();
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(2L);
        expectedPrimes.add(3L);
        expectedPrimes.add(5L);
        expectedPrimes.add(7L);
        expectedPrimes.add(11L);
        assertIterableEquals(expectedPrimes, primes);
    }

    @Test
    public void testGeneratePrimesFrom7To11() {
        PrimeGenerator generator = new PrimeGenerator(7, 11);
        generator.generatePrimes();
        LinkedList<Long> primes = generator.getPrimes();
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(7L);
        expectedPrimes.add(11L);
        assertIterableEquals(expectedPrimes, primes);
    }

    @Test
    public void testExceptionWhenFromWrongInputs() {
        try {
            PrimeGenerator generator = new PrimeGenerator(-2, 0);
            fail("testExceptionWhenFromWrongInputs failed");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-2 to=0", e.getMessage());
        }
    }

    @Test
    public void testExceptionWhenFromWrongInputs2() {
        try {
            PrimeGenerator generator = new PrimeGenerator(10, 10);
            fail("testExceptionWhenFromWrongInputs2 failed");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=10 to=10", e.getMessage());
        }
    }

    @Test
    public void testGeneratePrimesFrom50To60() {
        PrimeGenerator generator = new PrimeGenerator(50, 60);
        generator.generatePrimes();
        LinkedList<Long> primes = generator.getPrimes();
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(53L);
        expectedPrimes.add(59L);
        assertIterableEquals(expectedPrimes, primes);
    }
}
