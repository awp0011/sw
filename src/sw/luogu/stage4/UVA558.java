package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class UVA558 {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static final int[] distance = new int[1003];
    private static final int[][] edges = new int[2003][3];
    private static int n, m;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 0; t < T; t++) {
            in.nextToken();
            n = (int) in.nval;
            Arrays.fill(distance, INF);
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                edges[i][0] = (int) in.nval;
                in.nextToken();
                edges[i][1] = (int) in.nval;
                in.nextToken();
                edges[i][2] = (int) in.nval;
            }
            System.out.println(bellman_Ford() ? "possible" : "not possible");
        }
    }

    private static boolean bellman_Ford() {
        distance[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean noRelaxed = true;
            for (int j = 0; j < m; j++) {
                if (distance[edges[j][1]] > distance[edges[j][0]] + edges[j][2]) {
                    distance[edges[j][1]] = distance[edges[j][0]] + edges[j][2];
                    noRelaxed = false;
                }
            }
            if (noRelaxed) break;
        }
        for (int j = 0; j < m; j++) {
            if (distance[edges[j][1]] > distance[edges[j][0]] + edges[j][2]) return true;
        }
        return false;
    }
}
