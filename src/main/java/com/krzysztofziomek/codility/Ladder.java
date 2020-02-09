package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class Ladder {

    private int[] buildP() {
        int[] P = new int[31];
        P[0] = 1;
        for (int i = 1; i < P.length; i++) {
            P[i] = P[i - 1] << 1;
        }
        return P;
    }

    private int[] fibL(int n, int p30) {
        int[] fib = new int[n + 1];
        fib[1] = 1;
        if (n >= 2) {
            fib[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % p30;
        }
        return fib;

    }

    public int[] solution(int[] A, int[] B) {
        int[] P = buildP();
        int[] fib = fibL(A.length, P[30]);

        int[] L = new int[A.length];
        for (int i = 0; i < L.length; i++) {
            L[i] = fib[A[i]] % P[B[i]];
        }
        return L;

    }

}
