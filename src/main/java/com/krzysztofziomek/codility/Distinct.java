package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 04/05/2017.
 */
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Distinct {

    public class MergeSort{

        public int[] sort(int[] A){
            if (A == null || A.length <= 1){
                return A;
            } else {
                return sort(A, 0, A.length - 1);
            }
        }

        public int[] sort(int[] A, int start, int end) {
            int[] merged = new int[end - start + 1];
            if (start == end){ // 1 elem
                merged[0] = A[start];
                return merged;
            }
            if (start + 1 == end) { // 2 elems
                if (A[start] <= A[end]) {
                    merged[0] = A[start];
                    merged[1] = A[end];
                } else {
                    merged[0] = A[end];
                    merged[1] = A[start];
                }
                return merged;
            }

            // more than 2 elems

            int mid = (end + start) / 2;
            int[] left = sort(A, start, mid);
            int[] right = sort(A, mid+1, end);
            int pos = 0, l =0, r=0;

            while (l<left.length && r<right.length){
                if (left[l] <= right[r]){
                    merged[pos] = left[l];
                    l++;
                    pos++;
                } else {
                    merged[pos] = right[r];
                    r++;
                    pos++;
                }
            }
            while(r<right.length){
                merged[pos]= right[r];
                pos++;
                r++;
            }
            while(l<left.length){
                merged[pos]=left[l];
                pos++;
                l++;
            }
            return merged;

        }

    }


    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if ( A.length == 1) {
            return 1;
        }

        int[] sortedA = new MergeSort().sort(A);

        int count = 1;
        int lastCounted = sortedA[0];
        for (int i = 1; i< sortedA.length; i++){
            if (lastCounted != sortedA[i]){
                count++;
                lastCounted = sortedA[i];
            }
        }
        return count;

    }


}
