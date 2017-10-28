package sw.pro.SDS_PRO_7_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(climbStairs(Integer.parseInt(br.readLine())));
		br.close();
	}

	static int climbStairs(int n) {

		int dp1 = 1, dp2 = 2, dpWay = 0;
		if (n <= 1)
			return dp1;
		if (n == 2)
			return dp2;

		while (((n--) - 2) > 0) {
			dpWay = dp1 + dp2;
			if (dpWay > MOD)
				dpWay %= MOD;
			dp1 = dp2;
			dp2 = dpWay;
		}
		return dpWay;
	}

}
