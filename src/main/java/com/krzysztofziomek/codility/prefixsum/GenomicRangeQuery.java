package com.krzysztofziomek.codility.prefixsum;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {

        int[] A = new int[S.length()];
        int[] C = new int[S.length()];
        int[] G = new int[S.length()];
        int[] T = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                A[i] = 1;
            } else if (S.charAt(i) == 'C') {
                C[i] = 1;
            } else if (S.charAt(i) == 'G') {
                G[i] = 1;
            } else if (S.charAt(i) == 'T') {
                T[i] = 1;
            }
        }
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
            C[i] = C[i] + C[i - 1];
            G[i] = G[i] + G[i - 1];
            T[i] = T[i] + T[i - 1];
        }

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            if (contains(P[i], Q[i], A)) {
                result[i] = 1;
            } else if (contains(P[i], Q[i], C)) {
                result[i] = 2;
            } else if (contains(P[i], Q[i], G)) {
                result[i] = 3;
            } else if (contains(P[i], Q[i], T)) {
                result[i] = 4;
            }
        }
        return result;
    }

    private boolean contains(int p, int q, int[] Pre) {
        int num = Pre[q];
        if (p > 0) {
            num -= Pre[p - 1];
        }
        return num > 0;
    }

}
