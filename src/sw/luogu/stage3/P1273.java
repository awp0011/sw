package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;

public class P1273 {
    private static int[] next, val, p, cnt;
    private static boolean[] vis;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        next = new int[n + 1];
        val = new int[n + 1];
        p = new int[n + 1];
        cnt = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;
        in.nextToken();
        int m = (int) in.nval;
        int i, k, a, c;
        for (i = 1; i <= (n - m); i++) {
            in.nextToken();
            k = (int) in.nval;
            for (int j = 0; j < k; j++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                c = (int) in.nval;
                next[a] = i;
                val[a] -= c;
            }
        }
        int ans = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (; i <= n; i++) {
            in.nextToken();
            val[i] += (int) in.nval;
            if (val[i] >= 0) {
                deque.add(i);
                cnt[i] = 1;
                vis[i] = true;
            }
        }
        while (!deque.isEmpty()) {
            int nn = deque.poll();
            union(nn, next[nn]);
            val[next[nn]] += val[nn];
            if (val[next[nn]] >= 0 && !vis[next[nn]]) {
                deque.add(next[nn]);
                vis[next[nn]] = true;
            }
        }
        System.out.println(cnt[find(1)]);
    }

    private static int find(int c) {
        if (p[c] == c) return c;
        return p[c] = find(p[c]);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 > p2) {
            p[p1] = p2;
            cnt[p2] += cnt[p1];
        } else if (p1 < p2) {
            p[p2] = p1;
            cnt[p1] += cnt[p2];
        }
    }
}
