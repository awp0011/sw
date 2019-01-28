package sw.TP2019.M02.P05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][N];
        dp[0][0] = map[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) dp[i][j + 1] = max(dp[i][j + 1], dp[i][j] + map[i][j + 1]);
                if (i + 1 < N) dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] + map[i + 1][j]);
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
