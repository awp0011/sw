package sw.pro.SDS_PRO_5_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source2 {
	static int MOD = 100_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tc = br.readLine().split(" ");
		int N = Integer.parseInt(tc[0]);
		int K = Integer.parseInt(tc[1]);
		long[][][] dp = new long[1001][1001][2];
		dp[0][1][0] = 1;
		dp[0][1][1] = 1;
		for (int i = 2; i <= 100; i++) {
			dp[0][i][0] = dp[0][i - 1][0] + dp[0][i - 1][1];
			dp[0][i][1] = dp[0][i - 1][0];
		}
		for (int i = 1; i <= 100; i++)
			for (int j = 2; j <= 100; j++) {
				dp[i][j][0] = dp[i][j - 1][1] + dp[i][j - 1][0];
				dp[i][j][0] = (dp[i][j][0] + MOD) % MOD;
				dp[i][j][1] = dp[i - 1][j - 1][1] + dp[i][j - 1][0];
				dp[i][j][1] = (dp[i][j][1] + MOD) % MOD;
			}

		System.out.println(dp[K][N][0] + dp[K][N][1]);
	}

}
