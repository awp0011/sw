package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1378 {
    private static final int offset = 1000;
    private static int n, x1, x2, y1, y2;
    private static int[][] node;
    private static double[][] r, diff;
    private static double ans;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = offset + (int) in.nval;
        in.nextToken();
        x1 = offset + (int) in.nval;
        in.nextToken();
        y1 = offset + (int) in.nval;
        in.nextToken();
        x2 = offset + (int) in.nval;
        in.nextToken();
        y2 = offset + (int) in.nval;

        node = new int[n][3];//x,y,isVisited
        r = new double[n][2];//半径
        diff = new double[n][n];//所有点之间的距离
        for (int i = 0; i < n; i++) {
            in.nextToken();
            node[i][0] = offset + (int) in.nval;
            in.nextToken();
            node[i][1] = offset + (int) in.nval;
            r[i][1] = min2Bound(node[i][0], node[i][1]);
            for (int j = i; j > 0; j--) {
                diff[i][j] = diff[j][i] = diff(node[i][0], node[i][1], node[j][0], node[j][1]);
            }
        }
        System.out.println(Math.round(ans + 0.5));
    }

    private static void dfs(double sum, int cnt) {
        if (cnt == n) {
            if (sum > ans) ans = sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (node[i][2] == 1) continue;
            node[i][2] = 1;
            dfs(sum + calcu(i), cnt + 1);
            node[i][2] = 0;
        }
    }
    private static double calcu(int i){
        return 0;
    }

    private static double diff(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private static double min2Bound(int x, int y) {
        return Math.min(Math.min(Math.abs(x - x1), Math.abs(x - x2)), Math.min(Math.abs(y - y1), Math.abs(y - y2)));
    }
}
