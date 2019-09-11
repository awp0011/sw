package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1434 {
    private static final int[][] offset = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    private static int[][] map, dp;
    private static int R, C;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        R = (int) in.nval;
        in.nextToken();
        C = (int) in.nval;

        map = new int[R+5][C+5];
        dp = new int[R+5][C+5];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                in.nextToken();
                map[i][j] = (int) in.nval;
            }
        }
        System.out.println(LDS());
    }

    private static int LDS() {
        int maxLength = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                maxLength = Math.max(dfs(i, j), maxLength);
            }
        }
        return maxLength;
    }

    private static int dfs(int i, int j) {
        if (dp[i][j] > 0) return dp[i][j];
        else {
            for (int[] next : offset) {
                int nX = i + next[0];
                int nY = j + next[1];
                if (nX < 0 || nX >= R || nY < 0 || nY >= C) continue;
                if (map[nX][nY] > map[i][j]) continue;
                dp[i][j] = Math.max(dfs(nX, nY) + 1, dp[i][j]);
            }
            if (dp[i][j] == 0) dp[i][j] = 1;
            return dp[i][j];
        }
    }
}