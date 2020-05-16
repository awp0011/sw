package sw.pro.stone.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final Node[] nodes = new Node[100003];
    private static final ArrayList<Integer> ans0 = new ArrayList<>();
    private static final ArrayList<Integer> ans1 = new ArrayList<>();
    private static final Queue<Integer> queue = new LinkedList<>();
    private static long sum0;
    private static long sum1;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            in.nextToken();
            int k = (int) in.nval;

            for (int i = 1; i <= n; i++) {
                if (nodes[i] == null) nodes[i] = new Node();
                else nodes[i].init();
            }
            for (int i = 1; i <= m; i++) {
                in.nextToken();
                int a = (int) in.nval;
                in.nextToken();
                int b = (int) in.nval;
                in.nextToken();
                int p = (int) in.nval;
                in.nextToken();
                int q = (int) in.nval;
                nodes[a].adj.add(b);
                nodes[a].val += p;
                nodes[b].adj.add(a);
                nodes[b].val += q;
            }
            sum0 = 0;
            sum1 = 0;
            bfs();
            int kn;
            long max;
            if (sum0 >= sum1) {
                max = sum0;
                ans0.addAll(ans1);
                kn = ans0.get(k - 1);
            } else {
                max = sum1;
                ans1.addAll(ans0);
                kn = ans1.get(k - 1);
            }
            System.out.println("#" + t + " " + max + " " + kn);
            ans0.clear();
            ans1.clear();
        }
    }

    private static void bfs() {
        queue.add(1);
        nodes[1].same1 = true;
        nodes[1].vis = true;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            if (nodes[c].same1) {
                sum0 += nodes[c].val;
                ans0.add(c);
            } else {
                sum1 += nodes[c].val;
                ans1.add(c);
            }
            for (int next : nodes[c].adj) {
                if (nodes[next].vis) continue;
                nodes[next].vis = true;
                nodes[next].same1 = !nodes[c].same1;
                queue.add(next);
            }
        }

    }

    private static class Node {
        final HashSet<Integer> adj;
        long val;
        boolean same1;
        boolean vis;

        Node() {
            adj = new HashSet<>();
            init();
        }

        void init() {
            same1 = false;
            vis = false;
            val = 0;
            adj.clear();
        }
    }

}
