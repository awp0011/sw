package sw.pro.SUM;
/*
 * 动态规划
 * 数字可重复
 * ２＋１　和１＋２　是两种不同的拆分方式
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class source {

	public static void main(String[] args) throws Exception {
		int MOD = 1_000_000_000;
		int n, k;
		int[][] dp = new int[201][201];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;//任何数被分成１个都是只有１种分法
		}
		for (int i = 2; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print("[i,j]("+i+","+j+")->");
				for (int m = 0; m <= j; m++) {
					System.out.print("["+(i - 1)+","+(j - m)+"]");
					dp[i][j] = (dp[i][j] + dp[i - 1][j - m]) % MOD;
				}
				System.out.println();
			}
		}
		System.out.println(dp[k][n] % MOD);
		//System.out.println(dp[n][n]);//整数ｎ的全部分解组合数
		for (int i = 1; i <= k; i++) {
			System.out.println(Arrays.toString(Arrays.copyOf(dp[i], n+1)));
		}
	}

}
