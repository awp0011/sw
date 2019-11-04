package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1144 {
    private static final int MOD = 100_003;
    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node();
        nodes[1].cnt = 1;
        nodes[1].depth = 1;
        int x, y;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;
            nodes[x].adj.add(y);
            nodes[y].adj.add(x);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.depth - o2.depth;
            }
        });
        pq.add(nodes[1]);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int next : cur.adj) {
                int nd = cur.depth + 1;
                if (nodes[next].depth > nd) {
                    nodes[next].depth = nd;
                    nodes[next].cnt = cur.cnt;
                    pq.add(nodes[next]);
                } else if (nodes[next].depth == nd) {
                    nodes[next].cnt += cur.cnt;
                    nodes[next].cnt %= MOD;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) ans.append(nodes[i].cnt).append('\n');
        System.out.print(ans.toString());

    }

    private static class Node {
        int depth;
        int cnt;
        final ArrayList<Integer> adj = new ArrayList<>();;

        Node() {
            depth = INF;
            cnt = 0;
        }
    }
}
