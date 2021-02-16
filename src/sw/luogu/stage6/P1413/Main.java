package sw.luogu.stage6.P1413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R, C;
    private final static int[][][] map = new int[2][105][105];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[0][i][j] = Integer.parseInt(st.nextToken());
                map[1][i][j] = 0;
            }
        }
        System.out.println(lds());
    }

    private static int lds() {//最长下降子序列
        int max_length_lds = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                max_length_lds = Math.max(dfs(i, j), max_length_lds);
            }
        }
        return max_length_lds + 1;
    }

    private static int dfs(int r, int c) {
        if (map[1][r][c] > 0) return map[1][r][c];
        int current_Height = map[0][r][c];
        int length;
        if (r > 0 && current_Height > map[0][r - 1][c]) {
            length = dfs(r - 1, c);
            map[1][r][c] = Math.max(length + 1, map[1][r][c]);
        }
        if (c > 0 && current_Height > map[0][r][c - 1]) {
            length = dfs(r, c - 1);
            map[1][r][c] = Math.max(length + 1, map[1][r][c]);
        }
        if (r < R - 1 && current_Height > map[0][r + 1][c]) {
            length = dfs(r + 1, c);
            map[1][r][c] = Math.max(length + 1, map[1][r][c]);
        }
        if (c < C - 1 && current_Height > map[0][r][c + 1]) {
            length = dfs(r, c + 1);
            map[1][r][c] = Math.max(length + 1, map[1][r][c]);
        }
        return map[1][r][c];
    }

}