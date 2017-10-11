package sw.pro.city.spy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int	maxn	= 51;
	static int	maxt	= 201;
	static int	INF		= 0x3f3f3f3f;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][][] has_train = new int[maxt][maxn][2];
		int[] t = new int[maxn];
		int[][] dp = new int[maxt][maxn];
		int n, T, M1, M2, d;
		int Case = 0;
		n = Integer.parseInt(br.readLine().trim());
		while (n != 0) {
			T = Integer.parseInt(br.readLine().trim());
			String[] tcArr = br.readLine().trim().split(" ");
			for (int i = 1; i < n; i++) {
				t[i] = Integer.parseInt(tcArr[i - 1]);
			}

			M1 = Integer.parseInt(br.readLine().trim());
			int index = 0;
			tcArr = br.readLine().trim().split(" ");
			while (M1-- != 0) {
				d = Integer.parseInt(tcArr[index]);
				index++;
				for (int j = 1; j < n; j++) {
					if (d <= T)
						has_train[d][j][0] = 1;
					d += t[j];
				}
			}

			M2 = Integer.parseInt(br.readLine().trim());
			tcArr = br.readLine().trim().split(" ");
			index = 0;
			while (M2-- != 0) {
				d = Integer.parseInt(tcArr[index]);
				index++;
				for (int j = n - 1; j > 0; j--) {
					if (d <= T)
						has_train[d][j + 1][1] = 1;
					d += t[j];
				}
			}

			for (int i = 1; i < n; i++) {
				dp[T][i] = INF;
			}
			dp[T][n] = 0;
			for (int i = T - 1; i >= 0; i--) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i + 1][j] + 1;
					if (j < n && has_train[i][j][0] == 1 && i + t[j] <= T)
						dp[i][j] = Math.min(dp[i][j], dp[i + t[j]][j + 1]);
					if (j > 1 && has_train[i][j][1] == 1 && i + t[j - 1] <= T)
						dp[i][j] = Math.min(dp[i][j], dp[i + t[j - 1]][j - 1]);
				}
			}
			// Case Number 2: 0
			Case++;
			System.out.print("Case Number " + Case + ": ");
			if (dp[0][1] >= INF) {
				System.out.println("impossible");
			} else {
				System.out.println(dp[0][1]);
			}
			n = Integer.parseInt(br.readLine().trim());
			has_train = new int[maxt][maxn][2];
		}
		br.close();
	}

}
