package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1058 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        int[][] dp = new int[m + 3][n + 3];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                in.nextToken();
                dp[i][j] = (int) in.nval;
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1])) + dp[i][j];
            }
        }

        System.out.println(Math.max(dp[m][1 + n / 2], Math.max(dp[m][2 + n / 2], dp[m][n / 2])));
    }
}
