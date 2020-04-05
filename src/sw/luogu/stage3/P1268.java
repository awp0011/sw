package sw.luogu.stage3;

import java.io.*;

public class P1268 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int[][] t = new int[31][31];
        int N = (int) in.nval;
        while (N != 0) {
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    in.nextToken();
                    t[i][j] = (int) in.nval;
                }
            }
            int a = t[1][2], n;
            for (int i = 3; i <= N; i++) {
                n = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++)
                    for (int k = j + 1; k < i; k++) n = Integer.min(n, (t[j][i] + t[k][i] - t[j][k]) >> 1);
                a += n;
            }
            System.out.println(a);
            in.nextToken();
            N = (int) in.nval;
        }
    }
}
