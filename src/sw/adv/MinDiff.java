package sw.adv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class MinDiff {
    private static final ArrayDeque<Node> deque = new ArrayDeque<>();
    private static final Node[] nodes = new Node[1001];
    private static int N, S, E, max, min;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 1000; i++) nodes[i] = new Node(i);
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            N = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            in.nextToken();
            S = (int) in.nval;
            in.nextToken();
            E = (int) in.nval;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            int x, y, c;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                x = (int) in.nval;
                in.nextToken();
                y = (int) in.nval;
                in.nextToken();
                c = (int) in.nval;
                max = Math.max(c, max);
                min = Math.min(c, min);
                nodes[x].adj.add(new int[]{y, c});
                nodes[y].adj.add(new int[]{x, c});
            }
            int ans = max - min;
            //二分查找
            int l = 0, r = ans - 1, mid;
            while (l <= r) {
                mid = (l + r) >> 1;
                if (bfs(mid)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println("#" + t + " " + ans);
            for (int i = 1; i <= N; i++) nodes[i].adj.clear();
        }
    }

    private static boolean bfs(int minDiff) {
        int cMin, cMax;
        for (int i = min; i + minDiff <= max; i++) {
            cMin = i;
            cMax = i + minDiff;
            for (int j = 1; j <= N; j++) nodes[j].init();
            nodes[S].isVis = true;
            deque.add(nodes[S]);
            while (!deque.isEmpty()) {
                Node node = deque.poll();
                for (int[] next : node.adj) {
                    if (nodes[next[0]].isVis) continue;
                    nodes[next[0]].isVis = true;
                    if (next[1] > cMax) continue;
                    if (next[1] < cMin) continue;
                    union(node.index, next[0]);
                    deque.add(nodes[next[0]]);
                }
            }
            if (find(S) == find(E)) return true;
        }
        return false;
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
        final int index;
        int parent;
        boolean isVis;
        final ArrayList<int[]> adj;

        Node(int i) {
            index = i;
            init();
            adj = new ArrayList<>();
        }

        void init() {
            parent = index;
            isVis = false;
        }
    }
}
