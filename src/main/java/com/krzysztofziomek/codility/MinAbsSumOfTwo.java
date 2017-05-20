package com.krzysztofziomek.codility;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class MinAbsSumOfTwo {

    private int abs(int num){
        if (num >=0){
            return num;
        } else {
            return num - 2*num;
        }
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int min = abs(A[0]+A[0]);

        int left = 0;
        int right=A.length-1;

        while (left<right && A[left] < 0 && A[right] > 0) {
            min = Math.min(min, abs(A[left]+A[right]));
            if (abs(A[left])>A[right]){
                left++;
            } else{
                right--;
            }
        }

        if (left<=right && A[left]<=0 && A[right]<=0){
            min = Math.min(min, abs(2 * A[right]));
        }
        if (left<=right && A[left]>=0 && A[right]>=0){
            min = Math.min(min, 2*A[left]);
        }

        return min;

    }
}
