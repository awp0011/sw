package sw.pro.prictice.P0053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {

    private static final double[][] f = new double[1003][1003];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 1; i <= 1000; i++) {
            f[i][0] = 1;
            for (int j = 1; j <= 1000; j++) {
                double w2 = C(i) * f[i - 1][j];
                double b2 = C(j) * f[i][j - 1];
                double w1b1 = (i * j) * f[i - 1][j - 1];
                f[i][j] = (w2 + b2 + w1b1) / C(i + j);
            }
        }


        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            int W = (int) in.nval;
            in.nextToken();
            int B = (int) in.nval;
            String ansW = String.format("%.7f", f[W][B]);
            String ansB = String.format("%.7f", f[B][W]);
            String oth = String.format("%.7f", (1d - f[W][B] - f[B][W]));
            System.out.println("#" + t + " " + ansW + " " + ansB + " " + oth);
        }
    }

    private static int C(int n) {
        return (n * (n - 1)) >> 1;
    }
}
