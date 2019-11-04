package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1040 {
    private static int n;
    private static int[] V = new int[30];
    private static int[][] dp = new int[30][30];
    private static int[][] root = new int[30][30];
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            V[i] = (int) in.nval;
            dp[i][i] = V[i];
        }
        System.out.println(dfs(1, n));
        RLD(1, n);
        System.out.println(ans.toString());
    }

    private static int dfs(int l, int r) {
        if (dp[l][r] > 0) return dp[l][r];
        if (l == r) return V[l];
        if (r < l) return 1;
        for (int i = l; i <= r; i++) {
            int sor = dfs(l, i - 1) * dfs(i + 1, r) + dp[i][i];
            if (sor > dp[l][r]) {
                dp[l][r] = sor;
                root[l][r] = i;
            }
        }
        return dp[l][r];
    }

    private static void RLD(int l, int r) {
        if (r < l) return;
        if (l == r) {
            ans.append(l).append(' ');
            return;
        }
        ans.append(root[l][r]).append(' ');
        RLD(l, root[l][r] - 1);
        RLD(root[l][r] + 1, r);
    }

}
