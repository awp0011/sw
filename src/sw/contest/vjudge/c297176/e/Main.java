package sw.contest.vjudge.c297176.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static final int[][] dp = new int[103][103];
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = parseInt(st.nextToken());
            int S = parseInt(st.nextToken());
            int Q = parseInt(st.nextToken());
            if (C == 0 && S == 00 && Q == 0) break;
            for (int i = 1; i <= C; i++) {
                Arrays.fill(dp[i], INF);
            }
            for (int i = 0; i < S; i++) {
                st = new StringTokenizer(br.readLine());
                int c1 = parseInt(st.nextToken());
                int c2 = parseInt(st.nextToken());
                int d = parseInt(st.nextToken());

                dp[c1][c2] = d;
                dp[c2][c1] = d;
            }
            floyd(C);
            sb.append("Case #").append(index++).append('\n');
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int c1 = parseInt(st.nextToken());
                int c2 = parseInt(st.nextToken());
                sb.append((dp[c1][c2] == INF) ? "no path" : dp[c1][c2]).append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString().substring(0, sb.length() - 2));
    }

    private static void floyd(int end) {
        for (int k = 1; k <= end; k++) {
            for (int i = 1; i <= end; i++) {
                if (k == i) continue;
                if (dp[i][k] == INF) continue;
                for (int j = 1; j <= end; j++) {
                    if (k == j || i == j) continue;
                    if (dp[k][j] == INF) continue;
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k], dp[k][j]));
                }
            }
        }

    }
}
