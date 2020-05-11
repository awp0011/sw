package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;
import static java.lang.Integer.min;

public class Solution20200410_DFSIT {
    private static final int Max = 20002;
    private static final int[] d = new int[Max];//dfs 深度
    private static final int[] m = new int[Max];//第一次出现在欧拉序列位置
    private static final int[] tree = new int[Max * 6];
    private static final ArrayDeque<Integer> ad = new ArrayDeque<>();
    private static final Node[] nodes = new Node[Max];
    private static int offset;
    private static int index;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            Arrays.fill(tree, Integer.MAX_VALUE);
            in.nextToken();
            int n = (int) in.nval;
            offset = 1;
            while (offset < (2 * n - 1)) offset <<= 1;
            index = 0;

            in.nextToken();
            int q = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                if (nodes[i] == null) nodes[i] = new Node();
                else nodes[i].init();
            }
            int b;
            int a;
            for (int i = 1; i < n; i++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
                nodes[a].adj.add(b);
                nodes[b].adj.add(a);
            }
            dfs();
            //init Indexed Tee
            for (int i = offset - 1; i >= 1; i--) {
                tree[i] = min(tree[i * 2], tree[i * 2 + 1]);
            }
            int sum = 0;
            for (int i = 0; i < q; i++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
                if (m[a] > m[b]) sum += query(m[b], m[a]);
                else sum += query(m[a], m[b]);
            }
            System.out.println("#" + t + " " + sum);
            Arrays.fill(m, 0, n, 0);
        }
    }

    private static int query(int s, int e) {
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) min = min(min, tree[s]);
            if (s % 2 == 0) min = min(min, tree[e]);
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return min;
    }

    private static void dfs() {
        ad.addFirst(1);
        d[1] = 1;
        recode(1);
        while (!ad.isEmpty()) {
            int n = ad.peek();
            if (nodes[n].adj.size() > 0) {
                int next = nodes[n].adj.remove(0);
                ad.addFirst(next);
                d[next] = d[n] + 1;
                recode(next);
            } else {
                ad.poll();
                if (!ad.isEmpty()) recode(ad.peek());
            }
        }
    }

    private static void recode(int n) {
        tree[offset + index++] = d[n];
        if (m[n] == 0) m[n] = offset + index;
    }

    private static class Node {
        final LinkedList<Integer> adj;

        Node() {
            adj = new LinkedList<>();
            init();
        }

        void init() {
            adj.clear();
        }
    }
}
