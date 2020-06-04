package sw.luogu.stage5.P5731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static int[][] offset = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int cnt = 1;
        int[][] map = new int[n][n];
        int x = 0, tmpx, y = 0, tmpy, idx = 0;
        while (cnt <= n * n) {
            map[x][y] = cnt++;
            tmpx = x + offset[idx % 4][0];
            tmpy = y + offset[idx % 4][1];
            if (tmpx < 0 || tmpx >= n || tmpy < 0 || tmpy >= n || map[tmpx][tmpy] > 0) idx++;
            x = x + offset[idx % 4][0];
            y = y + offset[idx % 4][1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < 10) System.out.print("  ");
                else System.out.print(' ');
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}
