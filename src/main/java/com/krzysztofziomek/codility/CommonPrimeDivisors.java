package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class CommonPrimeDivisors {

    private int gcd(int a, int b){
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private int reduceWithGCD(int i, int gcd) {
        i = i/gcd;
        while (i != 1 && gcd !=1) {
            gcd = gcd(i, gcd);
            i = i/gcd;
        }
        return i;
    }

    public int solution(int[] A, int[] B) {
        int counter = 0;

        for (int i =0; i<A.length;i++){
            int a = A[i];
            int b = B[i];

            int gcd = gcd(a,b);

            a = reduceWithGCD(a, gcd);
            b = reduceWithGCD(b, gcd);

            if (a == 1 && b == 1) {
                counter++;
            }

        }

        return counter;

    }

}
