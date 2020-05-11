package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P2850 {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static int n, m, w, idx;
    private static int[] dist = new int[503];
    private static int[][] edges = new int[5203][3];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 0; t < T; t++) {
            in.nextToken();
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            in.nextToken();
            w = (int) in.nval;

            Arrays.fill(dist, INF);
            idx = 0;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                edges[idx][0] = (int) in.nval;
                in.nextToken();
                edges[idx][1] = (int) in.nval;
                in.nextToken();
                edges[idx++][2] = (int) in.nval;

                edges[idx][0] = edges[idx - 1][1];
                edges[idx][1] = edges[idx - 1][0];
                edges[idx++][2] = (int) in.nval;
            }
            for (int i = 0; i < w; i++) {
                in.nextToken();
                edges[idx][0] = (int) in.nval;
                in.nextToken();
                edges[idx][1] = (int) in.nval;
                in.nextToken();
                edges[idx++][2] = -(int) in.nval;
            }
            System.out.println(bellman_Ford() ? "YES" : "NO");
        }
    }

    private static boolean bellman_Ford() {
        dist[1] = 0;
        for (int i = 1; i < n - 1; i++) {
            boolean onRelaxed = true;
            for (int j = 0; j < idx; j++) {
                if (dist[edges[j][1]] > dist[edges[j][0]] + edges[j][2]) {
                    dist[edges[j][1]] = dist[edges[j][0]] + edges[j][2];
                    onRelaxed = false;
                }
            }
            if (onRelaxed) break;
        }
        for (int j = 0; j < idx; j++) {
            if (dist[edges[j][1]] > dist[edges[j][0]] + edges[j][2]) return true;
        }

        return false;
    }
}
