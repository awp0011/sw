package sw.luogu.stage3;

import java.io.*;
import java.util.ArrayDeque;

/*
1. TopologySort 去除链上的点
2. 并查集 算出环中的点
3. 链上的点 dfs 到环
* */
public class P2921 {
    private static int[] path;
    private static int[] dp;
    private static int[] p;
    private static final ArrayDeque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("E:\\BaiduNetdiskDownload\\testdata.in"));
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (3).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        path = new int[N + 1];
        dp = new int[N + 1];
        int[] idr = new int[N + 1];
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            in.nextToken();
            path[i] = (int) in.nval;
            idr[path[i]]++;
            p[i] = i;
            dp[i] = 1;
        }
        //TopologySort
        for (int i = 1; i <= N; i++) {
            if (idr[i] == 0) deque.add(i);
        }
        while (!deque.isEmpty()) {
            int n = deque.poll();
            dp[n] = -1;
            if (--idr[path[n]] == 0) deque.add(path[n]);
        }
        for (int i = 1; i <= N; i++) if (dp[i] != -1 && dp[path[i]] != -1) union(i, path[i]);
        for (int i = 1; i <= N; i++) if (dp[i] == -1) dfs(i);

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) ans.append(dp[find(i)]).append('\n');
        System.out.print(ans.toString());
    }

    private static int find(int c) {
        if (p[c] == c) return c;
        return p[c] = find(p[c]);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 != p2) {
            p[p1] = p2;
            dp[p2] += dp[p1];
        }
    }

    private static void dfs(int n) {
        deque.add(n);
        int num;
        while (!deque.isEmpty()) {
            num = deque.peekLast();
            if (dp[find(path[num])] > 0) {
                dp[num] = dp[find(path[num])] + 1;
                deque.pollLast();
            } else {
                deque.add(path[num]);
            }
        }
    }
}


