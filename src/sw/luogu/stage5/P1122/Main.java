package sw.luogu.stage5.P1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static long[] dp;
    private static int[] d, head;
    private static Edge[] edges;
    private static int idx = 1;
    private static long ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        dp = new long[n + 3];
        d = new int[n + 3];
        head = new int[n + 3];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
        }
        edges = new Edge[2 * n];
        for (int i = 1; i < n; i++) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            addEdge(a, b);
            addEdge(b, a);
        }
        dfs(1, 0);
        System.out.println(ans);
    }

    private static void dfs(int from, int parent) {
        dp[from] = d[from];
        for (int i = head[from]; i != 0; i = edges[i].next) {
            if (parent != edges[i].to) {
                dfs(edges[i].to, from);
                dp[from] += Math.max(0, dp[edges[i].to]);
            }
        }
        ans = Math.max(dp[from], ans);
    }

    private static void addEdge(int u, int v) {
        edges[idx] = new Edge();
        edges[idx].next = head[u];
        edges[idx].to = v;
        head[u] = idx++;
    }

    private static class Edge {
        int next;
        int to;

        Edge() {
        }
    }
}
