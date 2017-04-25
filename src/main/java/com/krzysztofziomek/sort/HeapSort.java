package com.krzysztofziomek.sort;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 24/04/2017.
 */
public class HeapSort {

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void exchange(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void maxHeapify(int[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && A[l] > A[largest]) {
            largest = l;
        }
        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchange(A, i, largest);
            maxHeapify(A, largest, heapSize);
        }
    }

    public void buildMaxHeap(int[] A) {
        int heapSize = A.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(A, i, A.length);
        }
    }

    public void heapSort(int[] A) {
        int heapSize = A.length;
        buildMaxHeap(A);
        for (int i = A.length - 1; i >= 1; i--) {
            exchange(A, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(A, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        System.out.println(Arrays.toString(A));

        heapSort.heapSort(A);

        System.out.println(Arrays.toString(A));

    }

}
