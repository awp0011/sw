package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1216 {
    private static final int[][] dp = new int[1003][1003];
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        in.nextToken();
        int N = (int) in.nval;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                in.nextToken();
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + (int) in.nval;
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) if (ans < dp[N][i]) ans = dp[N][i];
        System.out.println(ans);
    }
}
