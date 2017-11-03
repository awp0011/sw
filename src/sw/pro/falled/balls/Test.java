package sw.pro.falled.balls;

import java.math.BigDecimal;

public class Test {
	static long MOD = 1_000_000_007;

	public static void main(String[] args) {
		System.out.println(climbStairs(99_999_990));
		System.out.println(climbStairs_b(99_999_990));
	}

	static int climbStairs_b(int n) {
		double sqrt5 = Math.sqrt(5);
		double sqrt5_p1 = (Math.sqrt(5) + 1) / 2;
		double sqrt5_s1 = (1 - Math.sqrt(5)) / 2;
		// double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n
		// + 1);
		BigDecimal fibn = BigDecimal.valueOf(sqrt5_p1).pow(n + 1).subtract(BigDecimal.valueOf(sqrt5_s1).pow(n + 1));
		return (fibn.divide(BigDecimal.valueOf(sqrt5)).divideAndRemainder(BigDecimal.valueOf(1_000_000_007))[0]
				.intValue());
	}

	static long climbStairs(long n) {
		if (n == 1)
			return 1;
		long[][] input = { { 1, 1 }, { 1, 0 } };
		long[][] temp = pow(input, n - 1);
		long[][] output = new long[2][2];
		long[][] orign = { { 1, 0 }, { 1, 0 } };
		output = mult(temp, orign);
		return output[0][0];
	}

	static long[][] pow(long[][] input, long n) {
		long[][] output = new long[2][2];
		if (n == 0) {
			long[][] temp = { { 1, 0 }, { 0, 1 } };
			return temp;
		}
		if (n % 2 == 0) {
			output = pow(input, n / 2);
			long[][] temp = new long[2][2];
			temp = mult(output, output);
			return temp;
		} else {
			output = pow(input, n / 2);
			long[][] temp = new long[2][2];
			temp = mult(output, output);
			return mult(temp, input);
		}
	}

	static long[][] mult(long[][] input1, long[][] input2) {
		long[][] temp = new long[2][2];
		temp[0][0] = input1[0][0] * input2[0][0] + input1[0][1] * input2[1][0];
		temp[0][1] = input1[0][0] * input2[0][1] + input1[0][1] * input2[1][1];
		temp[1][0] = input1[1][0] * input2[0][0] + input1[1][1] * input2[1][0];
		temp[1][1] = input1[1][0] * input2[0][1] + input1[1][1] * input2[1][1];
		temp[0][0] %= MOD;
		temp[0][1] %= MOD;
		temp[1][0] %= MOD;
		temp[1][1] %= MOD;
		return temp;
	}

}
