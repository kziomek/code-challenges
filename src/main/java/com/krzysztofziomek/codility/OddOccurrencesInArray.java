package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        int unpaired = 0;
        for (int i : A) {
            unpaired = unpaired ^ i;
        }
        return unpaired;

    }

    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int[] A = {9, 3, 9, 3, 9, 7, 9};

        int odd = oddOccurrencesInArray.solution(A);
        System.out.println(odd);

    }
}
