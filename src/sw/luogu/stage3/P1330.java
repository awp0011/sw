package sw.luogu.stage3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class P1330 {
    private static final ArrayDeque<Integer> deque = new ArrayDeque<>();
    private static Node[] nodes;
    private static boolean[] isVis;
    private static int M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Downloads\\testdata (3).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        isVis = new boolean[N + 1];
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        in.nextToken();
        M = (int) in.nval;
        int a, b;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            a = (int) in.nval;
            in.nextToken();
            b = (int) in.nval;
            nodes[a].adj.add(b);
            nodes[b].adj.add(a);
            union(a, b);
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (isVis[i]) continue;
            if (nodes[i].adj.size() == 0) continue;
            if (nodes[i].parent != i) continue;

            ans += bfs(i);
        }

        System.out.println(M == 0 ? ans : "Impossible");
    }

    private static int bfs(int p) {
        int b = 1, w = 0;
        isVis[p] = true;
        deque.add(p);
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int n : nodes[cur].adj) {
                if (isVis[n]) continue;
                nodes[n].bw = nodes[cur].bw + 1;
                if (nodes[n].bw % 2 == 0) b++;
                else w++;
                M--;
                isVis[n] = true;
                deque.add(n);
            }
        }

        return b > w ? w : b;
    }

    private static int find(int c) {
        if (nodes[c].parent == c) return c;
        return nodes[c].parent = find(nodes[c].parent);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 != p2) nodes[p1].parent = p2;

    }

    private static class Node {
        int parent;
        int bw;
        ArrayList<Integer> adj;

        Node(int i) {
            parent = i;
            bw = 0;
            adj = new ArrayList<>();
        }
    }
}
