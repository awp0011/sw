package sw.luogu.stage6.P1807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static Edge[] edges;
    private static int[] last;
    private static int idx = 1;
    private static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(reader);
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        last = new int[n + 2];
        dist = new long[n + 2];
        edges = new Edge[m + 3];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int u = (int) st.nval;
            st.nextToken();
            int v = (int) st.nval;
            st.nextToken();
            int w = (int) st.nval;
            addEdge(u, v, -w);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Long.compare(dist[o1], dist[o2]);
            }
        });

        pq.add(1);
        Arrays.fill(dist, INF);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int i = last[cur]; i != 0; i = edges[i].next) {
                int to = edges[i].to;
                if (dist[to] > dist[cur] + edges[i].w) {
                    dist[to] = dist[cur] + edges[i].w;
                    pq.add(to);
                }
            }
        }
        System.out.println(dist[n] == INF ? -1 : -(dist[n]));
    }

    private static void addEdge(int u, int v, int w) {
        edges[idx] = new Edge();
        edges[idx].to = v;
        edges[idx].w = w;
        edges[idx].next = last[u];
        last[u] = idx++;
    }

    private static class Edge {
        int next;
        int to;
        int w;

        Edge() {
        }
    }
}
