package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class SolutionP0042 {
    private static StreamTokenizer in;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return edges[3][o1]-edges[3][o2];
        }
    });
    private static final int[] p = new int[52];
    //edges[0] 0不可用，1可用；edges[1]和edges[2] 线的端点; edges[3]: 权值
    private static final int[][] edges = new int[4][202];
    private static final int[][] pairs = new int[2][16];
    private static final HashMap<Integer, Boolean> map = new HashMap<>();
    private static int N, M, K;

    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    }

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        init();
        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            N = nextInt();
            M = nextInt();
            K = nextInt();
            for (int i = 1; i <= M; i++) {
                edges[0][i] = i;
                edges[1][i] = nextInt();
                edges[2][i] = nextInt();
                edges[3][i] = nextInt();
                pq.add(i);
            }
            for (int i = 0; i < K; i++) {
                pairs[0][i] = nextInt();
                pairs[1][i] = nextInt();
            }
            int total = (int) Math.pow(2, K);
            long min = Long.MAX_VALUE;
            for (int i = 0; i < total; i++) {
                int binary = i, idx = 0;
                while (binary > 0) {
                    if ((binary ^ 1) == 0) {
                        map.put(pairs[0][idx], true);
                        map.put(pairs[1][idx], false);
                    } else {
                        map.put(pairs[0][idx], false);
                        map.put(pairs[1][idx], true);
                    }
                    binary >>= 1;
                    idx++;
                }
                while (idx < K) {
                    map.put(pairs[0][idx], true);
                    map.put(pairs[1][idx], false);
                    idx++;
                }
                min = Math.min(min, MST());
            }
            if (min == Long.MAX_VALUE) min = -1;
            System.out.println("#" + t + " " + min);
        }
    }

    private static long MST() {
        long mst = 0;
        for (int i = 0; i < N; i++) p[i] = i;
        int cnt = 0;
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext() && cnt != N - 1) {
            int i = it.next();
            if (map.get(edges[0][i])) {
                if (union(edges[1][i], edges[2][i])) {
                    cnt++;
                    mst += edges[3][i];
                }
            }
        }
        if (cnt != N - 1) return Long.MAX_VALUE;
        return mst;
    }

    private static int find(int c) {
        if (p[c] == c) return c;
        return p[c] = find(p[c]);
    }

    private static boolean union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 == p2) return false;
        p[p1] = p2;
        return true;
    }
}
