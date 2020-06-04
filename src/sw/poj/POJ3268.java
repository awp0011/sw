package sw.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class POJ3268 {
    private static int INF = Integer.MAX_VALUE >> 1;
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        nodes = new Node[n + 2];
        for (int i = 1; i <= n; i++) nodes[i] = new Node(i, INF);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            nodes[u].adj1.add(new int[]{v, t});
            nodes[v].adj2.add(new int[]{u, t});
        }
        dijkstraU(x);
        dijkstraV(x);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (nodes[i].dist1 != INF && nodes[i].dist2 != INF) {
                ans = Math.max(ans, nodes[i].dist1 + nodes[i].dist2);
            }
        }
        System.out.println(ans);
    }

    private static void dijkstraU(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(100, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist1 - o2.dist1;
            }
        });
        nodes[s].dist1 = 0;
        pq.add(nodes[s]);
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            for (int i = 0; i < n.adj1.size(); i++) {
                int[] next = n.adj1.get(i);
                if (nodes[next[0]].dist1 > n.dist1 + next[1]) {
                    nodes[next[0]].dist1 = n.dist1 + next[1];
                    pq.add(nodes[next[0]]);
                }
            }
        }
    }

    private static void dijkstraV(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(100, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist2 - o2.dist2;
            }
        });
        nodes[s].dist2 = 0;
        pq.add(nodes[s]);
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            for (int i = 0; i < n.adj2.size(); i++) {
                int[] next = n.adj2.get(i);
                if (nodes[next[0]].dist2 > n.dist2 + next[1]) {
                    nodes[next[0]].dist2 = n.dist2 + next[1];
                    pq.add(nodes[next[0]]);
                }
            }
        }
    }

    private static class Node {
        int num;
        int dist1;
        int dist2;
        ArrayList<int[]> adj1, adj2;

        Node(int i, int v) {
            num = i;
            dist1 = v;
            dist2 = v;
            adj1 = new ArrayList<int[]>();
            adj2 = new ArrayList<int[]>();
        }

    }

}
