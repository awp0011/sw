package sw.pro.SUM;


import java.util.Scanner;

public class source_dp_3 {
    private static final int MOD = 1_000_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[][] dp = new int[202][202];
        dp[0][0] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[K][n]);
    }
}
