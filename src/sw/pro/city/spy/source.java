package sw.pro.city.spy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source {
	static int INF = 2000000000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, T, M1, M2;
		boolean[][][] has = new boolean[255][255][2];
		int[] t = new int[255];
		int[] d = new int[255];
		int[] e = new int[255];
		int[] ct = new int[255];
		int[][] dp = new int[255][255];
		int kase = 0;
		n = Integer.parseInt(br.readLine().trim());
		while (n != 0) {
			T = Integer.parseInt(br.readLine().trim());
			String[] tcArr = br.readLine().trim().split(" ");
			for (int i = 1; i <= n-1; i++){
				t[i] = Integer.parseInt(tcArr[i-1]);
				ct[i + 1] = ct[i] + t[i];
			}
			ct[1] = 0;
			t[n] = 0;
			
			
			M1 = Integer.parseInt(br.readLine().trim());

			tcArr = br.readLine().trim().split(" ");
			for (int i = 1; i <=M1; i++) {
				d[i] = Integer.parseInt(tcArr[i-1]);
			}

			M2 = Integer.parseInt(br.readLine().trim());
			tcArr = br.readLine().trim().split(" ");
			for (int i = 1; i < M2; i++) {
				e[i] = Integer.parseInt(tcArr[i-1]);
			}

			for (int i = 1; i <= M1; i++) {
				for (int j = 1; j <= n; j++) {
					has[d[i] + ct[j]][j][0] = true;
				}
			}
			for (int i = 1; i <= M2; i++) {
				for (int j = 1; j <= n; j++) {
					has[e[i] + ct[n] - ct[n - j + 1]][n - j + 1][1] = true;
				}
			}

			for (int i = 1; i < n; i++) {
				dp[T][i] = INF;
			}
			dp[T][n] = 0;

			for (int i = T - 1; i >= 0; i--) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i + 1][j] + 1;
					if (j < n && has[i][j][0] && i + t[j] <= T)
						dp[i][j] = Math.min(dp[i][j], dp[i + t[j]][j + 1]);
					if (j > 1 && has[i][j][1] && i + t[j - 1] <= T)
						dp[i][j] = Math.min(dp[i][j], dp[i + t[j - 1]][j - 1]);
				}
			}
			// Case Number 2: 0
			kase++;
			System.out.print("Case Number " + kase + ": ");
			if (dp[0][1] >= INF) {
				System.out.println("impossible");
			} else {
				System.out.println(dp[0][1]);
			}
			n = Integer.parseInt(br.readLine().trim());
		}
	}

}
