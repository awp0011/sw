package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P2258 {
    private static int n, m, r, c;
    private static int ans = Integer.MAX_VALUE;
    private static int[][] d = new int[20][20];
    private static int[][] dp = new int[20][20];
    private static int[] s = new int[20];


    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        in.nextToken();
        r = (int) in.nval;
        in.nextToken();
        c = (int) in.nval;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                in.nextToken();
                d[i][j] = (int) in.nval;
            }
        }
        int s = 0, e = 0, x, t;
        for (int i = 0; i < r; i++)
            s = s | (1 << i);
        for (int i = n - r; i < n; i++)
            e = e | (1 << i);
        while (s <= e) {
            find(s);
            x = s & (-s);
            t = s + x; //求下一个和S的二进制下的1的数量相同的数
            s = t | ((s ^ t) / x) >> 2;
        }
        System.out.println(ans);
    }

    private static void find(int t) {
        Arrays.fill(s, 0);
        for (int i = 0; i < n; i++) {
            if ((t & (1 << i)) > 0) s[++s[0]] = i + 1;
        }
        for (int[] f : dp) Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 0;
            for (int j = 2; j <= s[0]; j++) {
                dp[i][1] += Math.abs(d[s[j]][i] - d[s[j - 1]][i]);
            }
        }
        for (int i = 2; i <= c; i++) {
            for (int j = i; j <= m; j++) {
                for (int k = i - 1; k < j; k++) {
                    int x = 0, p = 1;
                    while (p <= s[0]) x += Math.abs(d[s[p]][k] - d[s[p++]][j]);
                    dp[j][i] = Math.min(dp[j][i], dp[k][i - 1] + dp[j][1] + x);
                }
            }
        }
        for (int i = c; i <= m; i++) {
            ans = Math.min(ans, dp[i][c]);
        }
    }
}
