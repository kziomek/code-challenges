package com.krzysztofziomek.codility.prefixsum;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class CountDiv {

    public int solution(int A, int B, int K) {
        return B/K - A/K + (A%K==0?1:0);
    }
}
