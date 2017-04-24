package com.krzysztofziomek.sort;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 24/04/2017.
 */
public class HeapSort {

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

//    private int parent(int i) {
//        return i/2;
//    }

    private void exchange(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void maxHeapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < A.length && A[l] > A[largest]) {
            largest = l;
        }
        if (r < A.length && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchange(A, i, largest);
            maxHeapify(A, largest);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] A = {0, 16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        System.out.println(Arrays.toString(A));
        heapSort.maxHeapify(A, 2);
        System.out.println(Arrays.toString(A));
    }


}
