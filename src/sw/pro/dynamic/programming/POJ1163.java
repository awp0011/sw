package sw.pro.dynamic.programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class POJ1163 {

	public static void main(String[] args) throws Exception {
		int[][] dp = new int[101][101];
		int[] maxSum;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxSum = dp[N];
		for (int i = N - 1; i >= 1; --i) {
			for (int j = 1; j <= i; ++j) {
				maxSum[j] = Math.max(maxSum[j], maxSum[j + 1]) + dp[i][j];
			}
		}
		System.out.println("the max sum:" + maxSum[1]);
		
		System.out.println("the dp arrays:"+Arrays.toString(maxSum));
	}

}
