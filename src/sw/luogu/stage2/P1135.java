package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1135 {
    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int A = (int) in.nval;
        in.nextToken();
        int B = (int) in.nval;
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node(i);
        for (int i = 1; i <= N; i++) {
            in.nextToken();
            int to = (int) in.nval;
            if (i + to <= N) nodes[i].adj[0] = (i + to);
            if (i - to >= 1) nodes[i].adj[1] = (i - to);
        }
        System.out.println(dijkstra(A, B, nodes));
    }

    private static int dijkstra(int s, int e, Node[] map) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.len - o2.len;
            }
        });
        map[s].len = 0;
        pq.add(map[s]);
        end:
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < 2; i++) {
                if (node.adj[i] > 0 && map[node.adj[i]].len > node.len + 1) {
                    map[node.adj[i]].len = node.len + 1;
                    pq.add(map[node.adj[i]]);
                    if (map[node.adj[i]].index == e) break end;
                }
            }

        }

        return map[e].len == INF ? -1 : map[e].len;

    }

    private static class Node {
        int index;
        int len;
        int[] adj;

        Node(int i) {
            index = i;
            len = INF;
            adj = new int[2];
        }
    }
}
