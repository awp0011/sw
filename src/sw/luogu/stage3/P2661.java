package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class P2661 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node();
        int[][] edges = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            nodes[i].parent = i;
            in.nextToken();
            nodes[i].next = (int) in.nval;
            nodes[nodes[i].next].inDepth++;
            edges[i][0] = i;
            edges[i][1] = nodes[i].next;
        }
        //拓扑排序，找环（可能多个）
        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (nodes[i].inDepth == 0) queue.add(nodes[i]);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            nodes[cur.next].inDepth--;
            if (nodes[cur.next].inDepth == 0) queue.add(nodes[cur.next]);
        }
        //并查集，找出合并后集合中 元素最少的
        for (int i = 1; i <= N; i++) union(edges[i][0], edges[i][1], nodes);
        int ans = N;
        for (int i = 1; i <= N; i++) {
            if (nodes[i].inDepth == 0) continue;
            if (nodes[i].parent != i) continue;
            ans = Math.min(ans, nodes[i].cnt);
        }
        System.out.println(ans);
    }

    private static int find(int c, Node[] nodes) {
        if (nodes[c].parent == c) return c;
        return nodes[c].parent = find(nodes[c].parent, nodes);
    }

    private static void union(int c1, int c2, Node[] nodes) {
        if (nodes[c1].inDepth == 0) return;
        if (nodes[c2].inDepth == 0) return;
        int p1 = find(c1, nodes);
        int p2 = find(c2, nodes);
        if (p1 != p2) {
            nodes[p1].parent = p2;
            nodes[p2].cnt += nodes[p1].cnt;
        }
    }

    private static class Node {
        int cnt = 1;
        int parent = 0;
        int inDepth = 0;
        int next = 0;
    }
}
