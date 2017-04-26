package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class CyclicRotation {
    /* shorter solution */
    public void rotate2(int[] A, int K) {
        int N = A.length;
        int[] copy = new int[A.length];
        System.arraycopy(A, 0, copy, 0, A.length);

        for (int i = 0; i < A.length; i++) {
            A[(i + K) % N] = copy[i];
        }


    }
    /* sollution with smaller array */
    public void rotate(int[] A, int K) {
        int N = A.length;
        K = K % N;

        int[] tmp = new int[K];
        for (int i = 0; i < K; i++) {
            tmp[i] = A[i];
        }

        for (int j = N - 1; j >= K; j--) {
            A[(j + K) % N] = A[j];
        }

        for (int k = K - 1; k >= 0; k--) {
            A[(k + K) % N] = tmp[k];
        }


    }
}
