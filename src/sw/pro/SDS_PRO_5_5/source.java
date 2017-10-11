package sw.pro.SDS_PRO_5_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source {
	// https://koitp.org/problem/ICPC_2009GNY_ADJACENTBIT/read/
	public static void main(String[] args) throws Exception {

		int[][][] dp = new int[1001][1001][2];
		dp[0][1][0] = 1;
		dp[0][1][1] = 1;
		for (int i = 2; i <= 1000; i++) {
			dp[0][i][0] = dp[0][i - 1][0] + dp[0][i - 1][1];
			dp[0][i][1] = dp[0][i - 1][0];
		}
		for (int i = 1; i <= 1000; i++) {
			for (int j = 2; j <= 1000; j++) {
				dp[i][j][0] = dp[i][j - 1][1] + dp[i][j - 1][0];
				dp[i][j][1] = dp[i - 1][j - 1][1] + dp[i][j - 1][0];
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int index = 1;
		while (index <= T) {
			String[] tc = br.readLine().split(" ");
			int N = Integer.parseInt(tc[1]);
			int K = Integer.parseInt(tc[2]);
			System.out.println(index + " " + (dp[K][N][0] + dp[K][N][1]));
			index++;
		}
		br.close();
	}

}
