package com.krzysztofziomek.dynamic;

/**
 * @author Krzysztof Ziomek
 * @since 06/05/2017.
 * f - fastet route
 * l -line
 */
public class AssemblyLineScheduling {

    private Result compute(int[][] a, int[][] t, int[][] e, int[][] x, int n) {

        int[][] f = new int[2][n];
        int[][] l = new int[2][n];
        int fTotal, lastLine;

        f[0][0] = e[0][0] + a[0][0];
        f[1][0] = e[1][0] + a[1][0];

        for (int j = 1; j < n; j++) {
            //line1
            if (f[0][j - 1] + a[0][j] < f[1][j - 1] + t[1][j - 1] + a[0][j]) {
                f[0][j] = f[0][j - 1] + a[0][j];
                l[0][j] = 1;
            } else {
                f[0][j] = f[1][j - 1] + t[1][j - 1] + a[0][j];
                l[0][j] = 2;
            }

            //line 2
            if (f[1][j - 1] + a[1][j] < f[0][j - 1] + t[0][j - 1] + a[1][j]) {
                f[1][j] = f[1][j - 1] + a[1][j];
                l[1][j] = 2;
            } else {
                f[1][j] = f[0][j - 1] + t[0][j - 1] + a[1][j];
                l[1][j] = 1;
            }
        }

        if (f[0][n - 1] + x[0][0] < f[1][n - 1] + x[1][0]) {
            fTotal = f[0][n - 1] + x[0][0];
            lastLine = 1;
        } else {
            fTotal = f[1][n - 1] + x[1][0];
            lastLine = 2;
        }

        return new Result(f, l, fTotal, lastLine);

    }

    public static void main(String[] args) {
        int[][] e = new int[][]{{2}, {4}};
        int[][] a = new int[][]{{7, 9, 3, 4, 8, 4}, {8, 5, 6, 4, 5, 7}};
        int[][] x = new int[][]{{3}, {2}};
        int[][] t = new int[][]{{2, 3, 1, 3, 4}, {2, 1, 2, 2, 1}};
        int n = 6; // nr of stations

        Result result = new AssemblyLineScheduling().compute(a, t, e, x, n);

        System.out.println("f* = " + result.getfTotal());
        System.out.println("Print stations:");


        int i = result.getLastLine();
        System.out.println("line " + i + " station " + n);
        for (int j = n - 1; j > 0; j--) {
            i = result.getL()[i - 1][j];
            System.out.println("line " + i + " station " + j);

        }


    }

    public class Result {

        public Result(int[][] f, int[][] l, int fTotal, int lastLine) {
            this.f = f;
            this.l = l;
            this.fTotal = fTotal;
            this.lastLine = lastLine;
        }

        int[][] f;
        int[][] l;
        int fTotal;
        int lastLine;

        public int getfTotal() {
            return fTotal;
        }

        public int getLastLine() {
            return lastLine;
        }

        public int[][] getF() {
            return f;
        }

        public int[][] getL() {
            return l;
        }
    }
}
