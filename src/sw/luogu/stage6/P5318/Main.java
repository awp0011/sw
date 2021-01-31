package sw.luogu.stage6.P5318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {
    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static final StringBuilder ans = new StringBuilder();
    private static final ArrayDeque<int[]> dque = new ArrayDeque<>();
    private static final ArrayDeque<Integer> bque = new ArrayDeque<>();
    private static boolean[] vis;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;

        vis = new boolean[n + 1];
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            adj.get(x).add(y);
        }
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() > 1) Collections.sort(adj.get(i));
        }
        dfs(1);
        Arrays.fill(vis, false);
        ans.append('\n');
        bfs(1);
        System.out.println(ans.toString());
    }

    private static void dfs(int start) {
        dque.addLast(new int[]{start, 0});
        ans.append(start);
        vis[start] = true;

        while (!dque.isEmpty()) {
            int[] cur = dque.peekLast();
            if (adj.get(cur[0]).isEmpty()) dque.pollLast();
            else if (cur[1] >= adj.get(cur[0]).size()) dque.pollLast();
            else {
                int next = adj.get(cur[0]).get(cur[1]);
                dque.peekLast()[1]++;
                if (!vis[next]) {
                    vis[next] = true;
                    dque.addLast(new int[]{next, 0});
                    ans.append(' ').append(next);
                }
            }
        }
    }

    private static void bfs(int start) {
        bque.addLast(start);
        ans.append(start);
        vis[start] = true;
        while (!bque.isEmpty()) {
            int cur = bque.pollFirst();
            if (adj.get(cur).isEmpty()) continue;
            for (int next : adj.get(cur)) {
                if (vis[next]) continue;
                vis[next] = true;
                bque.addLast(next);
                ans.append(' ').append(next);
            }
        }
    }
}
