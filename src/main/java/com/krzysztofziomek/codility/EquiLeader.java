package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 30/04/2017.
 */
public class EquiLeader {

    public int solution(int[] A) {
        int leader = 0;
        int count = 0;

        // find leader
        for (int num : A) {
            if (count == 0) {
                leader = num;
                count++;
                ;
            } else {
                if (num == leader) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int num : A) {
            if (num == leader) {
                count++;
            }
        }
        if (2 * count <= A.length) {
            return 0; // leader not found
        }

        // find equileaders
        int equiLeaderCount = 0;
        int leftCount = 0;
        int leftLeaderCount = 0;
        int rightCount = A.length;
        int rightLeaderCount = count;

        for (int num : A) {
            leftCount++;
            rightCount--;
            if (num == leader) {
                leftLeaderCount++;
                rightLeaderCount--;
            }
            if (2 * leftLeaderCount > leftCount && 2 * rightLeaderCount > rightCount) {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;

    }


}
