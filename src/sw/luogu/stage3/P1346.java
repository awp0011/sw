package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1346 {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static final PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.fee - o2.fee;
        }
    });

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int a = (int) in.nval;
        in.nextToken();
        int b = (int) in.nval;

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) nodes[i] = new Node();
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            int ki = (int) in.nval;
            for (int j = 0; j < ki; j++) {
                in.nextToken();
                int k = (int) in.nval;
                nodes[i].adj.add(new int[]{k, j == 0 ? 0 : 1});
            }
        }

        nodes[a].fee = 0;
        pq.add(nodes[a]);
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            for (int[] offset : u.adj) {
                int tb = u.fee + offset[1];
                if (nodes[offset[0]].fee > tb) {
                    nodes[offset[0]].fee = tb;
                    pq.add(nodes[offset[0]]);
                }
            }
        }
        System.out.println(nodes[b].fee == INF ? -1 : nodes[b].fee);
    }

    private static class Node {
        final ArrayList<int[]> adj = new ArrayList<>();
        int fee;
        Node() {
            fee = INF;
        }
    }
}
