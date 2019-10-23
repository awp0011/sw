package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P1005 {
    private static long[] base;
    private static long[][] dp;
    private static int[] d;
    private static int n, m;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;

        dp = new long[n + 3][m + 3];
        base = new long[m + 3];
        base[0] = 1;
        for (int i = 1; i <= m; i++) base[i] = base[i - 1] << 1;
        d = new int[m + 3];
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                in.nextToken();
                d[j] = (int) in.nval;
            }
            for (int k = 0; k <= n; k++) Arrays.fill(dp[k], -1);
            sum += find(1, m);
        }
        System.out.println(sum);
    }

    private static long find(int l, int r) {
        int k = m - (r - l);
        if (dp[l][r] != -1) return dp[l][r];
        if (r - l >= 1) dp[l][r] = Math.max(d[l] * base[k] + find(l + 1, r), find(l, r - 1) + d[r] * base[k]);
        else dp[l][r] = base[k] * d[l];
        return dp[l][r];
    }
}
