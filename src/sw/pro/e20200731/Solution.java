package sw.pro.e20200731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final int[] head = new int[20002];
    private static final Node[] nodes = new Node[20002];
    private static final Edge[] edges = new Edge[100002];
    private static final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingLong(o -> nodes[o].len));

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            int s = parseInt(st.nextToken());
            for (int i = 1; i <= n; i++) {
                if (nodes[i] == null) nodes[i] = new Node();
                else nodes[i].init();
            }
            int idx = 1;
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken());
                int v = parseInt(st.nextToken());
                int w = parseInt(st.nextToken());
                addEdge(u, v, w, idx++);
                addEdge(w, u, w, idx++);
            }

            //Dijkstra Method
            nodes[s].len = 0;
            nodes[s].weight = 0;
            nodes[s].outQueue = false;
            pq.add(s);
            while (!pq.isEmpty()) {
                int seq = pq.poll();
                if (nodes[seq].outQueue) continue;
                nodes[seq].outQueue = true;
                for (int i = head[seq]; i != 0; i = edges[i].next) {
                    long nextLen = nodes[seq].len + edges[i].weight;
                    if (nextLen < nodes[edges[i].to].len) {
                        nodes[edges[i].to].len = nextLen;
                        pq.add(edges[i].to);
                        nodes[s].outQueue = false;
                    } else if (nextLen == nodes[edges[i].to].len) {
                        if (nodes[edges[i].to].weight > edges[i].weight) {
                            nodes[edges[i].to].weight = edges[i].weight;
                            pq.add(edges[i].to);
                            nodes[s].outQueue = false;
                        }
                    }
                }
            }
            long ans = 0;
            for (int i = 1; i <= n; i++) ans += nodes[i].weight;
            System.out.println("#" + t + " " + ans);
        }
    }


    private static class Node {
        long len;
        int weight;
        boolean outQueue;

        Node() {
            init();
        }

        void init() {
            len = Long.MAX_VALUE >> 1;
            weight = Integer.MAX_VALUE;
            outQueue = true;
        }
    }

    private static class Edge {
        int to;
        int next;
        int weight;

        Edge() {
        }
    }

    private static void addEdge(int u, int v, int w, int i) {
        if (edges[i] == null) edges[i] = new Edge();
        edges[i].next = head[u];
        edges[i].to = v;
        edges[i].weight = w;
        head[u] = i;
    }
}
