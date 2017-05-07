package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int activeMax = 0;

        for (int i=0; i<A.length; i++){
            if (A[i]==N+1){
                activeMax = max;
            } else {
                if (counters[A[i]-1] < activeMax){
                    counters[A[i]-1] = activeMax;
                }
                counters[A[i]-1]++;
                if (counters[A[i]-1]>max){
                    max = counters[A[i]-1];
                }
            }
        }

        for (int j=0;j<counters.length;j++){
            if (counters[j] < activeMax){
                counters[j] = activeMax;
            }
        }
        return counters;
    }


}
