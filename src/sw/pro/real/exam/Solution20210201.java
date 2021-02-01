package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution20210201 {
    private static StreamTokenizer in;
    private static final long INF = Long.MIN_VALUE >> 1;
    private static final int MAX = 100002;
    private static int N, idx;
    private static final boolean[] vis = new boolean[MAX];
    private static final long[] dist = new long[MAX];
    private static final int[] supply = new int[MAX];

    //4个数组组成了链式前向星的数据结构：head next to val
    private static final int[] head = new int[MAX];
    private static final int[] next = new int[MAX];
    private static final int[] to = new int[2 * MAX];
    private static final int[] val = new int[2 * MAX];


    private static final PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Long.compare(dist[o1], dist[o2]);
        }
    });

    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    public static void main(String[] args) throws IOException {
        init();
        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = nextInt();
            int m = nextInt();
            int k = nextInt();
            idx = 1;
            for (int i = 0; i < m; i++) {
                int a = nextInt();
                int b = nextInt();
                int v = nextInt();
                addEdge(b, a, v);
            }
            for (int i = 0; i < k; i++) supply[nextInt()] = nextInt();

            dijkstra();
            System.out.println("#" + tc + " " + dist[1]);
        }
    }

    private static void dijkstra() {
        /*
        到N时携带的食物正好用完 ，求起点1最少要准备的食物数量
        所以 转化成 求N到1的最短路径  dist[N] = 0;
        */
        Arrays.fill(dist, 0, N + 1, INF);
        dist[N] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (!vis[cur]) continue;// 节点可能  同时 多次进入到PQ中，所以相同的节点 每次只处理1次
            vis[cur] = false;
            for (int i = head[cur]; i != 0; i = next[i]) {//链式前向星 遍历点
                int next = to[i];
                long tobe = dist[cur] + val[i] - supply[i];
                if (tobe < 0) tobe = 0;
                if (dist[next] > tobe) {
                    dist[next] = tobe;
                    pq.add(next);
                    vis[next] = true;
                }
            }
        }
    }

    private static void addEdge(int f, int t, int v) {
        next[idx] = head[f];
        head[f] = idx;
        val[idx] = v;
        to[idx++] = t;
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
