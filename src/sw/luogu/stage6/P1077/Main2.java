package sw.luogu.stage6.P1077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main2 {
    private static StreamTokenizer in;
    private static final int MOD = 1000007;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int n = nextInt();
        int m = nextInt();
        int[] a = new int[n + 3];
        int[][] f = new int[n + 3][m + 3];
        for (int i = 1; i <= n; i++) a[i] = nextInt();
        //for (int i = 1; i <= a[1]; i++) f[1][i] = 1;
        //f[i][j]表示前i项可以累加成j的方案书
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= Math.min(j, a[i]); k++) {
                    f[i][j] += f[i - 1][j - k];
                    f[i][j] %= MOD;
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
