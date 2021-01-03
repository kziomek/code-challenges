package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class CountNonDivisable {

    public int[] solution2(int[] A) {
        int[] count = new int[2 * A.length + 1];
        for (int a : A) {
            count[a]++;
        }
        int[] nonDivisors = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            nonDivisors[i] = nonDivisors(A[i], count, A.length);
        }
        return nonDivisors;
    }

    private int nonDivisors(int num, int[] counters, int N) {
        N -= counters[1];
        if (num == 1) {
            return N;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                N -= counters[i];
                if (i * i != num) {
                    N -= counters[num / i];
                }
            }
        }
        N -= counters[num];
        return N;
    }

    public int[] solution(int[] A) {
        // Compute the frequency of occurrence of each element in array A
        int[] count = new int[2 * A.length + 1];
        int max = 0;
        for (int a : A) {
            count[a]++;
            max = Math.max(max, a);
        }
        int[] divisors = calculateDivisors(count, max);
        int[] nonDivisors = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            nonDivisors[i] = A.length - divisors[A[i]];
        }
        return nonDivisors;
    }

    private int[] calculateDivisors(int[] counters, int max) {
        int[] divisors = new int[counters.length];
        for (int divisor = 1; divisor < counters.length; divisor++) {
            if (counters[divisor] == 0) continue;
            int multiple = divisor;
            while (multiple <= max) {
                divisors[multiple] += counters[divisor];
                multiple += divisor;
            }
        }
        return divisors;
    }
}