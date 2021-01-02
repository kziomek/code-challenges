package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 02/01/2021.
 */

class StoneWall {
    public int solution(int[] H) {
        int[] stack = new int[H.length];
        int stackIdx = -1;
        int stones = 0;

        for (int h : H) {
            while (stackIdx >= 0 && stack[stackIdx] > h) {
                stackIdx--;
            }

            if (stackIdx < 0 || stack[stackIdx] < h) {
                stack[++stackIdx] = h;
                stones++;
            }
        }
        return stones;
    }
}