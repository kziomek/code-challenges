package com.krzysztofziomek.fb.Q_5726326363783168;

/**
 * https://www.careercup.com/question?id=5726326363783168
 * n = 3 --> [1,1,2,2,3,3]
 *
 * run(n) will produce numbers with distance between the same numbers equal to their value
 * 312132
 * 231213
 *
 */
public class Algorithm {

    private void run(int num) {
        int[] perm = new int[num * 2];
        placeNumber(perm, num);
    }

    private void placeNumber(int[] perm, int num) {
        if (num == 0) {
            print(perm);
            return;
        }
        for (int i = 0; i < perm.length - num - 1; i++) {
            if (perm[i] == 0 && perm[i + num + 1] == 0) {
                int[] cperm = new int[perm.length];
                System.arraycopy(perm, 0, cperm, 0, perm.length);
                cperm[i] = num;
                cperm[i + num + 1] = num;
                placeNumber(cperm, num - 1);
            }
        }
    }

    private void print(int[] perm) {
        for (int i : perm) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Algorithm a = new Algorithm();
        a.run(3);
    }
}
