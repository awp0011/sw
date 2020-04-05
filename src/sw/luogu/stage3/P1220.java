package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1220 {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static int[][] d;
    private static int n;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        int s = (int) in.nval;

        d = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i][0] = (int) in.nval;
            in.nextToken();
            d[i][1] = d[i - 1][1] + (int) in.nval;
        }

        int[][][] dp = new int[n + 1][n + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = dp[i][j][1] = INF;
            }
        }
        dp[s][s][0] = dp[s][s][1] = 0;
        for (int j = s; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                dp[i][j][0] = Math.min(dp[i + 1][j][0] + cal(i, i + 1, i, j + 1), dp[i + 1][j][1] + cal(i, j, i, j + 1));
                dp[i][j][1] = Math.min(dp[i][j - 1][0] + cal(i, j, i - 1, j), dp[i][j - 1][1] + cal(j - 1, j, i - 1, j));
            }
        }
        System.out.println(Math.min(dp[1][n][0], dp[1][n][1]));
    }

    private static int cal(int i, int j, int l, int r) {
        return (d[j][0] - d[i][0]) * (d[l][1] + d[n][1] - d[r - 1][1]);
    }
}
