package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class BinaryGap {

    public int getGap(int i) {
        int max = 0;
        int count = -1;

        while (i > 0) {
            int firstBit = i & 1;
            if (firstBit == 0 && count >= 0) {
                count++;
            }
            if (firstBit == 1) {
                max = max > count ? max : count;
                count = 0;
            }
            i = i >> 1;
        }
        return max;


    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        int gap = binaryGap.getGap(9);
        System.out.println(gap);
    }
}
