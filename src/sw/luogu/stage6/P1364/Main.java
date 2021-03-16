package sw.luogu.stage6.P1364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static StreamTokenizer in;
    private static int[] siz, val, dp;
    private static int[] head, next, to;
    private static int idx, sum, ans;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        siz = new int[n + 3];
        val = new int[n + 3];
        dp = new int[n + 3];
        head = new int[n + 3];
        next = new int[n + 3];
        to = new int[n + 3];
        idx = 1;

        for (int i = 1; i <= n; i++) {
            val[i] = nextInt();
            int u = nextInt();
            int v = nextInt();
            if (u > 0) addEdge(i, u);
            if (v > 0) addEdge(i, v);
        }
        ans = Integer.MAX_VALUE;
        dfs(1, 0, 0);
        dp(1, 0);
        System.out.println(ans);
    }

    private static void dfs(int u, int fa, int dep) {
        siz[u] = val[u];
        for (int i = head[u]; i > 0; i = next[i]) {
            int t = to[i];
            if (t == fa) continue;
            dfs(t, u, dep + 1);
            siz[u] += siz[t];
        }
        dp[1] += val[u] * dep;
    }

    private static void dp(int u, int fa) {
        for (int i = head[u]; i > 0; i = next[i]) {
            int t = to[i];
            if (t == fa) continue;
            dp[t] = dp[u] + siz[1] - siz[t] * 2;
            dp(t, u);
        }
        ans = Math.min(ans, dp[u]);
    }

    private static void addEdge(int f, int t) {
        next[idx] = head[f];
        to[idx] = t;
        head[f] = idx++;
    }
}
