package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class P1433 {
    private static final double[][] chess = new double[16][2];
    private static final double[][] dist = new double[16][16];
    private static final boolean[] used = new boolean[16];
    private static int n;
    private static double ans;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            chess[i][0] = in.nval;
            in.nextToken();
            chess[i][1] = in.nval;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) continue;
                double dx = abs(chess[i][0] - chess[j][0]);
                double dy = abs(chess[i][1] - chess[j][1]);
                dist[i][j] = dist[j][i] = sqrt(Math.pow(dx,2) + Math.pow(dy,2));
            }
        }
        ans = Long.MAX_VALUE;
        eat(0, 0, 0);
        System.out.printf("%.2f", ans);
    }

    private static void eat(int p, int cnt, double sum) {
        if (sum >= ans) return;
        if (cnt == n) {
            ans = sum;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            if (sum + dist[p][i] < ans) {
                used[i] = true;
                eat(i, cnt + 1, sum + dist[p][i]);
                used[i] = false;
            }
        }
    }
}
