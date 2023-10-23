package edu.umb.cs680.hw02;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void testGeneratePrimesFrom1To12() {
        // Create a PrimeGenerator instance
        PrimeGenerator generator = PrimeGenerator.getInstance();
        // Set the limits for prime generation
        generator.setLimits(1, 12);
        // Generate prime numbers
        generator.generatePrimes();
        // Get the generated prime numbers
        LinkedList<Long> primes = generator.getPrimes();
        // Define the expected prime numbers within the range
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(2L);
        expectedPrimes.add(3L);
        expectedPrimes.add(5L);
        expectedPrimes.add(7L);
        expectedPrimes.add(11L);
        // Assert that the generated prime numbers match the expected ones
        assertIterableEquals(expectedPrimes, primes);
    }

    @Test
    public void testExceptionWhenFromWrongInputs() {
        try {
            // Create a PrimeGenerator instance
            PrimeGenerator generator = PrimeGenerator.getInstance();
            // Set invalid limits
            generator.setLimits(-2, 0);
            // Attempt to generate primes with invalid input
            generator.generatePrimes();
            // If no exception is thrown, the test should fail
            fail("testExceptionWhenFromWrongInputs failed");
        } catch (RuntimeException e) {
            // Check that the exception message matches the expected one
            assertEquals("Wrong input values: from=-2 to=0", e.getMessage());
        }
    }

    @Test
    public void testGeneratePrimesFrom50To60() {
        // Create a PrimeGenerator instance
        PrimeGenerator generator = PrimeGenerator.getInstance();
        // Set the limits for prime generation
        generator.setLimits(50, 60);
        // Generate prime numbers
        generator.generatePrimes();
        // Get the generated prime numbers
        LinkedList<Long> primes = generator.getPrimes();
        // Define the expected prime numbers within the range
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(53L);
        expectedPrimes.add(59L);
        // Assert that the generated prime numbers match the expected ones
        assertIterableEquals(expectedPrimes, primes);
    }

    @Test
    public void testExceptionWhenFromWrongInputs2() {
        try {
            // Create a PrimeGenerator instance
            PrimeGenerator generator = PrimeGenerator.getInstance();
            // Set invalid limits where 'from' is equal to 'to'
            generator.setLimits(10, 10);
            // Attempt to generate primes with invalid input
            generator.generatePrimes();
            // If no exception is thrown, the test should fail
            fail("testExceptionWhenFromWrongInputs2 failed");
        } catch (RuntimeException e) {
            // Check that the exception message matches the expected one
            assertEquals("Wrong input values: from=10 to=10", e.getMessage());
        }
    }

    @Test
    public void testGeneratePrimesFrom7To11() {
        // Create a PrimeGenerator instance
        PrimeGenerator generator = PrimeGenerator.getInstance();
        // Set the limits for prime generation
        generator.setLimits(7, 11);
        // Generate prime numbers
        generator.generatePrimes();
        // Get the generated prime numbers
        LinkedList<Long> primes = generator.getPrimes();
        // Define the expected prime numbers within the range
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(7L);
        expectedPrimes.add(11L);
        // Assert that the generated prime numbers match the expected ones
        assertIterableEquals(expectedPrimes, primes);
    }
}
