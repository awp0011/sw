package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P1119 {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static int N;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;

        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            in.nextToken();
            T[i] = (int) in.nval;
        }
        int x, y;
        dp = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], INF);
        for (int i = 0; i < M; i++) {
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;
            in.nextToken();
            dp[x][y] = dp[y][x] = (int) in.nval;
        }
        in.nextToken();
        int Q = (int) in.nval;
        int ti, pos = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;
            in.nextToken();
            ti = (int) in.nval;
            if (T[x] > ti || T[y] > ti) ans.append(-1).append('\n');
            else {
                while ( pos < N && T[pos] <= ti ) {
                    update(pos);
                    pos++;
                }
                ans.append(dp[x][y] == INF ? -1 : dp[x][y]).append('\n');
            }
        }
        System.out.print(ans.toString());
    }

    private static void update(int k) {
        for (int i = 1; i < N; i++) {
            if (dp[i][k] == INF) continue;
            for (int j = 0; j < i; j++) {
                if (dp[k][j] == INF) continue;
                dp[i][j] = dp[j][i] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
            }
        }
    }
}
