package com.krzysztofziomek.codility.prefixsum;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class PassingCars {

    public int solution(int[] A) {
        int counter = 0;
        int eastCars = 0;
        int max = 1000000000;

        for (int i = 0; i<A.length; i++){
            if(A[i] == 0){
                eastCars++;
            }
            if(A[i] == 1){
                counter+=eastCars;
            }
            if (counter>max){
                return -1;
            }
        }
        return counter;
    }
}
