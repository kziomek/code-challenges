package com.krzysztofziomek.codility.dynamic;

/**
 * @author Krzysztof Ziomek
 * @since 21/05/2017.
 */
public class MinAbsSum {

    public int solution(int[] A) {
        int max = 0;
        for (int i=0; i<A.length; i++){
            max = max(max, abs(A[i]));
        }
        max = max*max;

        int[][] posDP = new int[A.length+1][max+1];
        int[][] negDP = new int[A.length+1][max+1];

        for (int j=0; j<max+1; j++){
            posDP[0][j]=0;
            negDP[0][j]=0;
        }
        for(int i=1; i<A.length+1; i++){
            for (int j=0; j<max+1; j++){
                posDP[i][j] = max+1;
                negDP[i][j] = -max-1;
            }
        }



        for (int i=0; i<A.length; i++){
            int posNum = abs(A[i]);
            int negNum = -posNum;

            for (int j=0; j<=max; j++){
                if (posDP[i][j] <= max) {
                    int idx1 = posNum + posDP[i][j];
                    int idx3 = negNum + posDP[i][j];

                    if (idx1 <= max) {
                        posDP[i+1][idx1] = idx1;
                    }

                    if (idx3>=0){
                        posDP[i+1][idx3] = idx3;
                    } else {
                        negDP[i+1][abs(idx3)] = idx3;
                    }
                }

                if (negDP[i][j] >= -max){
                    int idx2 = posNum + negDP[i][j];
                    int idx4 = negNum + negDP[i][j];

                    if(abs(idx4)<=max){
                        negDP[i+1][abs(idx4)] = idx4;
                    }

                    if (idx2 >=0){
                        posDP[i+1][idx2] = idx2;
                    } else{
                        negDP[i+1][abs(idx2)] = idx2;
                    }
                }

            }


        }

        int posMin = posDP[A.length][0];
        for (int i = 1; i<=max; i++){
            posMin = min(posMin, posDP[A.length][i]);
        }

        int negMin = abs(negDP[A.length][0]);
        for (int i = 1; i<=max; i++){
            negMin = min(negMin, abs(negDP[A.length][i]));
        }

        return min(posMin, negMin);
    }


    private int min(int a, int b){
        return a<=b ? a : b;
    }

    private int max(int a, int b){
        return a >= b ? a : b;
    }

    private int abs(int n) {
        return n>=0 ? n : -n;
    }
}
