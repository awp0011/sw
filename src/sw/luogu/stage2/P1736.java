package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1736 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] dp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                in.nextToken();
                dp[i][j] = (int) in.nval;
                if (i > 0 && j > 0) {
                    if (dp[i][j] > 0 && dp[i - 1][j - 1] > 0 && dp[i - 1][j] + dp[i][j - 1] == 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    } else if (dp[i][j] + dp[i - 1][j - 1] == 0 && dp[i - 1][j] > 0 && dp[i][j - 1] > 0) {
                        dp[i][j - 1] = dp[i - 1][j] + 1;
                        ans = Math.max(ans, dp[i][j - 1]);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
