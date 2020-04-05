package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1789 {
    private static boolean[][] map;
    private static final int[][] r1 = new int[][]{
            {-1, 0}, {-2, 0}, {1, 0}, {2, 0},
            {0, -1}, {0, -2}, {0, 1}, {0, 2},
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
    };
    private static final int[][] r2 = new int[][]{{-2, -2}, {2, 2}};
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static int n, m, k, x, y, ox, oy, cnt;

    public static void main(String[] args) throws Exception {
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        map = new boolean[n][n];
        cnt = n * n;
        for (int i = 0; i < m; i++) {
            readCase();
            light1();
        }
        for (int i = 0; i < k; i++) {
            readCase();
            light2();
        }
        System.out.println(cnt);
    }

    private static void readCase() throws IOException {
        in.nextToken();
        x = (int) in.nval;
        x--;
        in.nextToken();
        y = (int) in.nval;
        y--;
        if (!map[x][y]) cnt--;
        map[x][y] = true;
    }

    private static void light1() {
        for (int[] next : r1) {
            ox = x + next[0];
            oy = y + next[1];
            if (ox < 0 || ox >= n || oy < 0 || oy >= n) continue;
            if (map[ox][oy]) continue;
            cnt--;
            map[ox][oy] = true;
        }
    }

    private static void light2() {
        int ox1 = x + r2[0][0];
        if (ox1 < 0) ox1 = 0;
        int oy1 = y + r2[0][1];
        if (oy1 < 0) oy1 = 0;
        int ox2 = x + r2[1][0];
        if (ox2 >= n) ox2 = n - 1;
        int oy2 = y + r2[1][1];
        if (oy2 >= n) oy2 = n - 1;

        for (int i = ox1; i <= ox2; i++) {
            for (int j = oy1; j <= oy2; j++) {
                if (map[i][j]) continue;
                cnt--;
                map[i][j] = true;
            }
        }
    }
}
