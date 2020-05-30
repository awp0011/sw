package sw.luogu.stage4;

import java.io.*;

import static java.lang.Integer.min;

public class P3388 {
    private static int n, m, idx;
    private static Edge[] edges;
    private static int[] head, low, dfn;
    private static boolean[] cut;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Downloads\\P3388_1.in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;

        edges = new Edge[2 * m + 2];
        head = new int[n + 2];
        dfn = new int[n + 2];
        low = new int[n + 2];
        cut = new boolean[n + 2];
        idx = 1;
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            int u = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            addEdge(u, v);
            addEdge(v, u);
        }
        idx = 0;
        for (int i = 1; i <= n; i++) {
            if (dfn[i] == 0) {
                idx = 1;
                dfn[i] = idx;
                low[i] = idx++;
                dfs(i, i);
            }
        }
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (cut[i]) {
                cnt++;
                ans.append(i).append(' ');
            }
        }
        System.out.println(cnt);
        System.out.println(ans.toString());
    }

    private static void dfs(int s, int parent) {
        dfn[s] = idx;
        low[s] = idx++;
        int child = 0;
        for (int i = head[s]; i != 0; i = edges[i].next) {
            if (dfn[edges[i].to] == 0) {
                dfs(edges[i].to, s);
                low[s] = min(low[s], low[edges[i].to]);
                if (low[edges[i].to] >= dfn[s] && s != parent) cut[s] = true;
                if (s == parent) child++;

            }
            low[s] = min(low[s], dfn[edges[i].to]);
        }
        if (s == parent && child >= 2) cut[s] = true;
    }

    private static void addEdge(int from, int to) {
        edges[idx] = new Edge();
        edges[idx].next = head[from];
        edges[idx].to = to;
        head[from] = idx++;
    }

    private static class Edge {
        int next;
        int to;

        Edge() {
        }
    }
}
