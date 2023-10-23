package edu.umb.cs680.hw02;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGenerator {

    protected long from;
    protected long to;
    protected LinkedList<Long> primes = new LinkedList<>();
    private static PrimeGenerator gen;

    // Private constructor to enforce Singleton pattern
    private PrimeGenerator() { }

    // Singleton pattern to ensure only one instance is created
    public static PrimeGenerator getInstance() {
        if (gen == null) {
            gen = new PrimeGenerator();
        }
        return gen;
    }

    // Set the limits for prime generation
    public void setLimits(long from, long to) {
        if (from >= 1 && to > from) {
            this.from = from;
            this.to = to;
        } else {
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    // Get the list of generated prime numbers
    public LinkedList<Long> getPrimes() {
        return primes;
    }

    // Check if a number is even
    protected boolean isEven(long n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Check if a number is prime
    protected boolean isPrime(long n) {
        // 1 or lower numbers are not prime.
        if (n <= 1) {
            return false;
        }
        // Even numbers are not prime, except for 2.
        if (n > 2 && isEven(n)) {
            return false;
        }
        long i;
        // Find a number "i" that can divide "n"
        for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {
        }
        // If such a number "i" is found, n is not prime. Otherwise, n is prime.
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Generate prime numbers within the specified range
    public void generatePrimes() {
        primes.clear();
        for (long n = from; n <= to; n++) {
            if (isPrime(n)) {
                primes.add(n);
            }
        }
    }
}
