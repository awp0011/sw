package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.BitSet;

public class P1352 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Node[] nodes = new Node[n + 1];
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            nodes[i] = new Node(i);
            dp[i][1] += (int) in.nval;
        }
        int L, K;
        while (true) {
            in.nextToken();
            L = (int) in.nval;
            in.nextToken();
            K = (int) in.nval;
            if (L == 0 && K == 0) break;
            if (nodes[K].adj == null) nodes[K].adj = new BitSet();
            nodes[K].adj.set(L);
            nodes[L].up = K;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (nodes[i].adj == null) deque.add(i);
        }
        int cur = 0, next;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            if (nodes[cur].adj != null) {
                next = nodes[cur].adj.nextSetBit(0);
                while (next > 0) {
                    dp[cur][0] += Integer.max(dp[next][0], dp[next][1]);
                    dp[cur][1] += dp[next][0];
                    next = nodes[cur].adj.nextSetBit(next + 1);
                }
            }
            if (!nodes[nodes[cur].up].vis) {
                nodes[nodes[cur].up].vis = true;
                if (cur != nodes[cur].up) deque.add(nodes[cur].up);
            }
        }
        System.out.println(Integer.max(dp[cur][0], dp[cur][1]));
    }

    private static class Node {
        int up;
        boolean vis;
        BitSet adj;

        Node(int i) {
            up = i;
            vis = false;
        }
    }
}
