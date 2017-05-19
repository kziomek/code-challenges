package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 18/05/2017.
 */
public class NailingPlanks {

    public int solution(int[] A, int[] B, int[] C) {
        int begin = 0;
        int end = C.length - 1;
        int res = -1;

        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (check(A, B, C, mid+1)) {
                end = mid-1;
                res = mid+1;
            } else {
                begin = mid+1;
            }
        }
        return res;
    }

    public boolean check(int[] A, int[] B, int[] C, int num) {
        int[] nails = new int[2 * C.length + 1];
        for (int i = 0; i < num; i++) {
            nails[C[i]] = 1;
        }

        for (int i = 1; i < nails.length; i++) {
            nails[i] = nails[i] + nails[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            if (nails[B[i]] == nails[A[i] - 1]) {
                return false;
            }
        }
        return true;

    }
}
