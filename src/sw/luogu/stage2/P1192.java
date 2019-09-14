package sw.luogu.stage2;

import java.util.Scanner;

public class P1192 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i + j > N) continue;
                dp[i + j] += dp[i];
                dp[i + j] %= 100003;
            }
        }
        System.out.println(dp[N]);
    }
}
