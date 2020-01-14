package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1116 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] d = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i][0] = (int) in.nval;
            if (i > 1) {
                for (int j = i; j > 0; j--) if (d[i][0] < d[j][0]) d[i][1]++;
                d[0][0] += d[i][1];
            }
        }
        System.out.println(d[0][0]);
    }
}
