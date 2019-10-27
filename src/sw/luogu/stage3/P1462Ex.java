package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class P1462Ex {
    private static final long INF = Long.MAX_VALUE >> 1;
    private static Node[] nodes;
    private static int n, b, mid, l, r = -1;
    private static final PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c > o2.c ? 1 : -1;
        }
    });

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        long start = System.currentTimeMillis();
        n = (int) in.nval;
        nodes = new Node[n + 1];
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        b = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            nodes[i] = new Node((int) in.nval);
            r = Math.max(r, nodes[i].fee);
        }

        int ai, bi, ci;
        for (int i = 0; i < m; i++) {
            in.nextToken();
            ai = (int) in.nval;
            in.nextToken();
            bi = (int) in.nval;
            in.nextToken();
            ci = (int) in.nval;
            if (nodes[ai].adj == null) nodes[ai].adj = new ArrayList<>();
            nodes[ai].adj.add(new int[]{bi, ci});
            if (nodes[bi].adj == null) nodes[bi].adj = new ArrayList<>();
            nodes[bi].adj.add(new int[]{ai, ci});

        }
        nodes[1].c = 0;
        int ans = -1;
        l = nodes[1].fee;
        while (l <= r) {
            mid = (l + r) >> 1;
            //System.out.println(mid);
            if (dijkstra(mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans == -1 ? "AFK" : ans);
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }

    private static boolean dijkstra(int max) {
        for (int i = 2; i <= n; i++) {
            nodes[i].c = INF;
        }
        pq.add(nodes[1]);
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            if (u.adj == null) continue;
            for (int[] offset : u.adj) {
                if (nodes[offset[0]].fee > max) continue;
                long tb = u.c + offset[1];
                if (tb > b) continue;
                if (nodes[offset[0]].c > tb) {
                    nodes[offset[0]].c = tb;
                    pq.add(nodes[offset[0]]);
                }
            }
        }
        return nodes[n].c != INF;
    }

    private static class Node {
        int fee;
        long c;
        ArrayList<int[]> adj;

        Node(int fi) {
            fee = fi;
        }
    }
}
