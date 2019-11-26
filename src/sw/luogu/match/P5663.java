package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.BitSet;

public class P5663 {
    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) nodes[i] = new Node(i);
        int u, v;
        for (int i = 0; i < m; i++) {
            in.nextToken();
            u = (int) in.nval;
            in.nextToken();
            v = (int) in.nval;
            if (nodes[u].adj == null) nodes[u].adj = new BitSet();
            if (nodes[v].adj == null) nodes[v].adj = new BitSet();
            nodes[u].adj.set(v);
            nodes[v].adj.set(u);
        }

        ArrayDeque<Node> deque = new ArrayDeque<>();
        if (nodes[1].adj != null) {
            deque.add(nodes[1]);
            nodes[1].len = 0;
        }
        int lenCycle = INF, next, len, cnt;
        while (!deque.isEmpty()) {
            cnt = 0;
            next = 0;
            do {
                next = deque.peekLast().adj.nextSetBit(next + 1);
                if (next <= 0) continue;
                else {
                    len = nodes[deque.peekLast().index].len + 1;
                    if (next == 1 && len > 2) {
                        if (lenCycle > len) lenCycle = len;
                    } else if (nodes[next].len > len) {
                        nodes[next].len = len;
                        if (nodes[next].adj != null) {
                            deque.addLast(nodes[next]);
                            cnt++;
                        }
                    }
                }
            } while (next > 0);
            if (cnt == 0) deque.pollLast();
        }

        int a, L;
        if (lenCycle != INF) lenCycle--;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < q; i++) {
            in.nextToken();
            a = (int) in.nval;
            in.nextToken();
            L = (int) in.nval;
            if (nodes[a].len == INF) {
                ans.append("No").append('\n');
            } else if (a == 1) {
                if (L >= lenCycle) ans.append("Yes").append('\n');
                else ans.append((L % 2) == 0 ? "Yes" : "No").append('\n');
            } else {
                if (nodes[a].len == 1) {
                    ans.append((L % 2) == 1 ? "Yes" : "No").append('\n');
                } else ans.append((L % nodes[a].len) == 0 ? "Yes" : "No").append('\n');
            }
        }
        System.out.println(ans.toString());
    }

    private static class Node {
        final int index;
        BitSet adj;
        int len;

        Node(int i) {
            index = i;
            len = INF;
        }
    }
}
