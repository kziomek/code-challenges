package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class FibFrog {

    public int solution(int[] A) {
        int[] tmpA = A;
        A = new int[A.length+1];
        System.arraycopy(tmpA, 0, A, 0, tmpA.length);
        A[A.length-1] = 1;

        int[] fib = countFib(A.length);

        int[] jumps = new int[A.length];

        for(int i=0; i<A.length;i++){
            if (A[i] == 0) {
                continue;
            }
            int min  = A.length;
            for (int j=0; j<fib.length; j++){
                int preIdx = i-fib[j];
                if(preIdx == -1){ //left bank
                    jumps[i] = 1;
                    break;
                }
                if (preIdx < 0){
                    break;
                }
                if(A[preIdx] == 1){
                    if(jumps[preIdx]>0 && jumps[preIdx]<min) {
                        min = jumps[preIdx];
                        jumps[i] = min+1;
                    }
                }

            }

        }
        return jumps[jumps.length-1] != 0 ? jumps[jumps.length-1] : -1;
    }

    private int[] countFib(int N) {
        int[] fib = new int[2];
        fib[0]=1;
        fib[1]=2;

        int k;
        int idx = 1;
        while(true){
            idx++;
            k = fib[idx-1] + fib[idx-2];
            if (k > N){
                break;
            }
            int tmp[] = new int[fib.length+1];
            System.arraycopy(fib,0, tmp, 0, fib.length);
            fib = tmp;
            fib[idx]=k;

        }
        return fib;
    }


}
