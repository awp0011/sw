package sw.TP2019.M02.P04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int V = parseInt(st.nextToken());
        int E = parseInt(st.nextToken());
        int S = parseInt(st.nextToken());
        Edge[] edges = new Edge[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int v1 = parseInt(st.nextToken());
            int v2 = parseInt(st.nextToken());
            if (edges[v1] == null) edges[v1] = new Edge(v1);
            edges[v1].to.add(v2);
            if (edges[v2] == null) edges[v2] = new Edge(v2);
            edges[v2].to.add(v1);
        }
        Deque<Integer> sq = new ArrayDeque<>();
        StringBuilder sb2 = new StringBuilder(1000);
        //BFS
        edges[S].visited = true;
        edges[S].to.forEach(i -> {
            sq.add(i);
            edges[i].visited = true;
        });
        sb2.append(S);
        while (!sq.isEmpty() && sq.peek() != null) {
            int next = sq.poll();
            sb2.append(' ').append(next);
            edges[next].to.forEach(i -> {
                if (!edges[i].visited) {
                    sq.add(i);
                    edges[i].visited = true;
                }

            });
        }


        //DFS
        StringBuilder sb1 = new StringBuilder(1000);
        edges[S].visited = false;
        sq.add(S);
        sb1.append(S);
        while (!sq.isEmpty() && sq.peekFirst() != null) {
            int cur = sq.getFirst();
            if (edges[cur].to.isEmpty()) {
                sq.pollFirst();
            } else {
                int next = edges[cur].to.first();
                edges[cur].to.remove(edges[cur].to.first());
                if (edges[next].visited) {
                    sb1.append(' ').append(next);
                    edges[next].visited = false;
                    sq.offerFirst(next);
                }
            }
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
    }

    private static class Edge {
        int from;
        SortedSet<Integer> to;
        boolean visited;

        Edge(int f) {
            visited = false;
            from = f;
            to = new TreeSet<>();
        }
    }
}
