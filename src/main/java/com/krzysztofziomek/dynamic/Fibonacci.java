package com.krzysztofziomek.dynamic;


import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Krzysztof Ziomek
 * @since 23/01/2021.
 * <p>
 * https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
 * Dynamic Programming
 * Memoization (Top Down)
 */
public class Fibonacci {

    public int dpFib(int n, int[] lookup) {
        if (lookup[n] == 0) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = dpFib(n - 1, lookup) + dpFib(n - 2, lookup);
            }
        }
        return lookup[n];
    }

    public int recursiveFib(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    public static void main(String[] args) {
        int n = 20;
        Fibonacci fibonacci = new Fibonacci();

        Stopwatch time = Stopwatch.createStarted();
        int dpRes = fibonacci.dpFib(n, new int[n + 1]);
        time.stop();
        System.out.println("Result dynamic programming fib[" + n + "] = " + dpRes + " in time " + (time.elapsed(TimeUnit.NANOSECONDS)));

        time = Stopwatch.createStarted();
        int recRes = fibonacci.recursiveFib(n);
        time.stop();
        System.out.println("Result recursive fib[" + n + "] = " + recRes + " in time " + (time.elapsed(TimeUnit.NANOSECONDS)));
    }
}
