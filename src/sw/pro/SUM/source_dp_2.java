package sw.pro.SUM;

import java.io.InputStreamReader;
import java.util.Scanner;


public class source_dp_2 {

    public static void main(String[] args) throws Exception {
        int MOD = 1_000_000_000;
        int n, k;
        int[][] dp = new int[201][201];
        Scanner br = new Scanner(new InputStreamReader(System.in));
        n = br.nextInt();
        k = br.nextInt();
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;// 任何数被分成１个都是只有１种分法
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if (j != 0) {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j] % MOD;
                }
            }
        }
        System.out.println(dp[k][n]);
        // System.out.println(dp[n][n]);//整数ｎ的全部分解组合数
    }

}
