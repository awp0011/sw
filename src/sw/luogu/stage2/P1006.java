package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

public class P1006 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = parseInt(st.nextToken());
        int n = parseInt(st.nextToken());
        int[][] map = new int[51][51];
        int[][][][] dp = new int[51][51][51][51];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i + 1; k <= m; k++) {
                    for (int l = 1; l < j; l++) {
                        dp[i][j][k][l] = max4(
                                dp[i][j - 1][k][l - 1],
                                dp[i][j - 1][k - 1][l],
                                dp[i - 1][j][k - 1][l],
                                dp[i - 1][j][k][l - 1]
                        ) + map[i][j] + map[k][l];
                    }
                }
            }
        }

        System.out.println(dp[m - 1][n][m][n - 1]);

    }

    private static int max4(int one, int two, int three, int four) {
        return max(max(one, two), max(three, four));
    }
}
