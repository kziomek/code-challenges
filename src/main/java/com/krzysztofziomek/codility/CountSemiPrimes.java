package com.krzysztofziomek.codility;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 12/05/2017.
 *
 * CountSemiPrimes
 */
public class CountSemiPrimes {

    public static void main(String[] args) {
        CountSemiPrimes sieveOfEratoSthenes = new CountSemiPrimes();

        int[] P = new int[]{1, 4, 16};
        int[] Q = new int[]{26, 10, 20};

        int N = 26;
        int[] result = sieveOfEratoSthenes.solution(N, P, Q);
        System.out.println(Arrays.toString(result));

    }

    public int[] solution(int N, int[] P, int[] Q) {
        int m = P.length;
        int[] result = new int[m];

        int[] primes = primes(N);
        int[] semi = semi(primes);

        for (int i = 0; i < m; i++) {
            result[i] = semi[Q[i]] - semi[P[i] - 1];
        }

        return result;

    }

    private int[] primes(int N) {
        int[] A = new int[N + 1];

        for (int i = 2; i * i <= N; i++) {
            if (A[i] == 0) {
                for (int j = i * i; j <= N; j += i) {
                    if (A[j] == 0) {
                        A[j] = i;
                    }
                }
            }
        }
        return A;
    }


    private int[] semi(int[] primes) {
        int[] semi = new int[primes.length];
        int sum = 0;
        for (int i = 1; i < semi.length; i++) {
            if (primes[i] > 0) {
                if (primes[i / primes[i]] == 0) {
                    sum++;
                }
            }
            semi[i] = sum;
        }
        return semi;
    }

}
