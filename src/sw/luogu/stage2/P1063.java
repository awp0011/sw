package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1063 {
    private static int[][] dp;
    private static int[] d;
    private static int Max;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Max = 2 * n + 10;
        dp = new int[Max][Max];
        d = new int[Max];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
            d[n + i] = d[i];
        }
        d[2 * n + 1] = d[1];
        int ans = 0;
        for (int i = 1; i <= n; i++) ans = Math.max(ans, find(i, i + n - 1));
        System.out.println(ans);
    }

    private static int find(int l, int r) {
        if (dp[l][r] > 0) return dp[l][r];
        if (l - r == 1) return dp[l][r] = d[l] * d[r] * d[r + 1];
        for (int i = l; i < r; i++) {
            dp[l][r] = Math.max(dp[l][r], d[l] * d[i + 1] * d[r + 1] + find(l, i) + find(i + 1, r));
        }
        return dp[l][r];
    }

}
