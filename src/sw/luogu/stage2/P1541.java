package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.lang.Math.max;

public class P1541 {
    private static final int[][][][] dp = new int[41][41][41][41];
    private static final int[] C = new int[5];
    private static int[] L;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        L = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            L[i] = (int) in.nval;
        }
        for (int i = 0; i < m; i++) {
            in.nextToken();
            C[(int) in.nval]++;
        }
        dp[0][0][0][0] = L[1];
        System.out.println(dfs(C[1], C[2], C[3], C[4]));
    }

    private static int dfs(int a, int b, int c, int d) {
        if (dp[a][b][c][d] > 0) return dp[a][b][c][d];
        if (a > 0) dp[a][b][c][d] = max(dp[a][b][c][d], dfs(a - 1, b, c, d));
        if (b > 0) dp[a][b][c][d] = max(dp[a][b][c][d], dfs(a, b - 1, c, d));
        if (c > 0) dp[a][b][c][d] = max(dp[a][b][c][d], dfs(a, b, c - 1, d));
        if (d > 0) dp[a][b][c][d] = max(dp[a][b][c][d], dfs(a, b, c, d - 1));
        return dp[a][b][c][d] += L[1+a + 2 * b + 3 * c + 4 * d];
    }

}
