package com.krzysztofziomek.search;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class BinarySearch {

    public boolean search(int[] A, int key) {
        int low = 0;
        int high = A.length - 1;
        int middle;

        while (low <= high) {
            middle = (high + low) / 2;
            if (A[middle] == key) {
                return true;
            }
            if (A[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return false;

    }
}
