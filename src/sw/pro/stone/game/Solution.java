package sw.pro.stone.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Solution {
    private static final Edge[] edges = new Edge[400002];
    private static final int[] head = new int[100003];
    private static final int[] tree = new int[270000];
    private static final long[] nodeValue = new long[100003];
    private static final boolean[] hasIn = new boolean[100003];
    private static final PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static int zero, edgeIdx, kn;
    private static long max;


    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            edgeIdx = 0;
            zero = 1;
            max = 0;
            kn = 0;
            in.nextToken();
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            in.nextToken();
            int k = (int) in.nval;

            while (zero < n) zero <<= 1;
            for (int i = 1; i <= m; i++) {
                in.nextToken();
                int a = (int) in.nval;
                in.nextToken();
                int b = (int) in.nval;
                in.nextToken();
                int p = (int) in.nval;
                in.nextToken();
                int q = (int) in.nval;
                addEdge(a, b, q);
                addEdge(b, a, p);
                nodeValue[a] += p;
                nodeValue[b] += q;
            }
            zero -= 1;
            for (int i = 1; i <= n; i++) tree[zero + i] = i;
            for (int i = zero; i >= 1; i--) {
                int l = i << 1;
                int r = l + 1;
                tree[i] = nodeValue[l] > nodeValue[r] ? l : r;
            }
            //init
            while (nodeValue[tree[1]] != 0) {
                pq.add(tree[1]);
                hasIn[tree[1]] = true;
                max += nodeValue[tree[1]];
                nodeValue[tree[1]] = 0;
                for (int i = head[tree[1]]; i != 0; i = edges[i].next) {
                    update(edges[i].to, nodeValue[edges[i].to] - edges[i].val);
                }
                update(tree[1], 0);
            }
            if (pq.size() >= k) {
                while (k > 0) {
                    kn = pq.poll();
                    k--;
                }
            } else {
                k -= pq.size();
                while (k > 0) {
                    for (int i = 1; i <= n; i++) {
                        if (hasIn[i]) continue;
                        kn = i;
                        k--;
                    }
                }
            }
            System.out.println("#" + t + " " + max + " " + kn);
            Arrays.fill(hasIn, 0, n + 1, false);
            Arrays.fill(nodeValue, 0, n + 1, 0);
            Arrays.fill(tree, 0, 3*n + 1, 0);
            pq.clear();
        }
    }

    private static void update(int idx, long val) {
        nodeValue[idx] = val;
        int pos = (idx + zero) >> 1;
        while (pos > 0) {
            int l = pos << 1;
            int r = l + 1;
            tree[pos] = nodeValue[l] > nodeValue[r] ? l : r;
            pos >>= 1;
        }
    }

    private static void addEdge(int from, int to, int val) {
        if (edges[edgeIdx] == null) edges[edgeIdx] = new Edge();
        edges[edgeIdx].next = head[from];
        edges[edgeIdx].to = to;
        edges[edgeIdx].val = val;
        head[from] = edgeIdx++;
    }

    private static class Edge {
        int to, next;
        int val;

        Edge() {
        }
    }
}
