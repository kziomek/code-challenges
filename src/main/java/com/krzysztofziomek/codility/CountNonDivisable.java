package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class CountNonDivisable {

    public int[] solution(int[] A) {
        int[] nonDivisors = new int[A.length];

        int[] counters = new int[2 * A.length + 1];
        for (int a : A) {
            counters[a]++;
        }

        for (int i = 0; i < A.length; i++) {
            nonDivisors[i] = nonDivisors(A[i], counters, A.length);
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
                N -= counters[num / i];
                if (i * i == num) {
                    N += counters[i];
                }
            }

        }

        N -= counters[num];
        return N;

    }
}