package sw.luogu;

import java.util.Scanner;

public class P1028 {
    private static final int[] dp = new int[1005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= t; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i / 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[t]);
    }
}
