package sw.pro.SUM;
/*
 * 动态规划
 * 数字可重复
 * ２＋１　和１＋２　是两种不同的拆分方式
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class source_pro {

	public static void main(String[] args) throws Exception {
		int MOD = 1_000_000_000;
		int n, k;
		int[][] dp = new int[201][201];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;// 任何数被分成１个都是只有１种分法
		}
		for (int i = 2; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				// System.out.println("[i,j](" + i + "," + j + ")->[" + i + "," + (j - 1) +
				// "],[" + (i - 1) + "," + j + "]");
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
				}
			}
		}
		System.out.println(dp[k][n]);
		// System.out.println(dp[n][n]);//整数ｎ的全部分解组合数
		/*
		 * for (int i = 1; i <= k; i++) {
		 * System.out.println(Arrays.toString(Arrays.copyOf(dp[i], n + 1))); }
		 */
	}

}
