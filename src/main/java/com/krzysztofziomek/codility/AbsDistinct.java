package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 28/04/2017.
 *
 *
    Task description
    A non-empty zero-indexed array A consisting of N numbers is given. The array is sorted in non-decreasing order.
    The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

    For example, consider array A such that:

    A[0] = -5
    A[1] = -3
    A[2] = -1
    A[3] =  0
    A[4] =  3
    A[5] =  6
    The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given a non-empty zero-indexed array A consisting of N numbers, returns absolute distinct count of array A.

    For example, given array A such that:

    A[0] = -5
    A[1] = -3
    A[2] = -1
    A[3] =  0
    A[4] =  3
    A[5] =  6
    the function should return 5, as explained above.

    Assume that:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
    array A is sorted in non-decreasing order.
    Complexity:

    expected worst-case time complexity is O(N);
    expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
    Elements of input arrays can be modified.
 */


public class AbsDistinct {

    private long abs(long value) {
        return value < 0 ? -value : value;
    }

    public int solution(int[] A) {
        int l = 0, r = A.length - 1;
        long lv, rv;
        int count = 0;

        while (l <= r) {
            count++;
            lv = abs(A[l]);
            rv = abs(A[r]);

            if (lv > rv) {
                while (++l <= r && lv == abs(A[l]));
            } else if (lv < rv) {
                while (l <= --r && rv == abs(A[r]));
            } else {
                while (++l <= r && lv == abs(A[l]));
                while (l <= --r && rv == abs(A[r]));
            }
        }
        return count;
    }

    public int solution2(int[] A) {
        long[] B = new long[A.length];
        int l = 0, r = A.length - 1;
        long lVal;
        long rVal;

        // write sorted to array B
        int b = 0;
        while (l <= r) {
            lVal = abs(A[l]);
            rVal = abs(A[r]);
            if (lVal >= rVal) {
                B[b] = lVal;
                l++;
            } else {
                B[b] = rVal;
                r--;
            }
            b++;
        }

        //count
        long lastValue = B[0];
        int count = 1;
        for (long v : B) {
            if (v != lastValue) {
                count++;
                lastValue = v;
            }
        }
        return count;
    }
}