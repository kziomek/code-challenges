package com.krzysztofziomek.codility;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class CountTriangles {

    public int solution(int[] A) {
        int triangles = 0;
        Arrays.sort(A);

        for (int p = 0; p < A.length-2; p++){
            int z = p+2;

            for (int q=p+1; q<A.length;q++){
                while (z<A.length && A[z]<A[p]+A[q]){
                    z++;
                }
                triangles+=z-q-1;
            }
        }
        return triangles;
    }
}
