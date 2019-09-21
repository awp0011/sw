package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1025 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int K = (int) in.nval;
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
            dp[i][0] = 1;
        }
        for (int i = 2; i <= K; i++) {
            dp[1][i] = 0;
            dp[0][i] = 0;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                if (i > j) dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
                else dp[i][j] = dp[i - 1][j - 1];
            }
        }
        System.out.println(dp[N][K]);
    }
}
