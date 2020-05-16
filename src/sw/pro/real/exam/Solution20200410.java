package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Solution20200410 {
    private static final int Max = 20002;
    private static final Node[] nodes = new Node[Max];
    private static int N, Q, a, b;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            N = (int) in.nval;
            in.nextToken();
            Q = (int) in.nval;
            for (int i = 1; i <= N; i++) {
                if (nodes[i] == null) nodes[i] = new Node(i);
                else nodes[i].init();
            }
            for (int i = 1; i < N; i++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
                nodes[a].adj.add(b);
                nodes[b].adj.add(a);
            }
            for (int i = 0; i <Q ; i++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
            }
            int sum = 0;

            System.out.println(sum);
        }
    }

    private static int find(int c) {
        if (nodes[c].parent == c) return c;
        return nodes[c].parent = find(nodes[c].parent);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 < p2) nodes[p2].parent = p1;
        else if (p2 < p1) nodes[p1].parent = p2;
    }

    private static class Node {
        private final int index;
        private int depth;
        private boolean isVis;
        private int parent;
        private ArrayList<Integer> adj;

        Node(int i) {
            index = i;
            adj = new ArrayList<>();
            init();
        }

        void init() {
            depth = 0;
            isVis = false;
            parent = index;
            adj.clear();
        }
    }
}
