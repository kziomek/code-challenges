package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 18/05/2017.
 */
public class MinMaxDivision {

    private int countCubes(int[] A, int max) {
        int sum = 0;
        int cubes = 1;
        for (int i = 0; i < A.length; i++) {
            if (sum + A[i] <= max) {
                sum += A[i];
            } else {
                cubes++;
                sum = A[i];
            }
        }
        return cubes;
    }

    public int solution(int K, int M, int[] A) {
        int result = 0;

        int left = A[0];
        int right = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > left) left = A[i];
            right += A[i];
        }

        if (K == 1) return right;
        if (K >= A.length) return left;

        while (left <= right) {
            int mid = (right + left) / 2;
            int cubes = countCubes(A, mid);

            if (cubes <= K) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;

    }
}
