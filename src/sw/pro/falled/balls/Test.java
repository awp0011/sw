package sw.pro.falled.balls;

import java.math.BigInteger;

public class Test {
	static BigInteger[] tc = new BigInteger[201];

	public static void main(String[] args) {
		int n = 20;
		int k = 3;

		int M = n + 1;
		int N = k - 1;
		tc[1] = BigInteger.ONE;

		System.out.println(factorial(M).divide(factorial(N)).divide(factorial(M - N)));
	}

	static int s(int n, int k) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return s(n - 1, k - 1) + k * s(n - 1, k);
	}

	static BigInteger factorial(final int n) {
		if (tc[n] == null) {
			tc[n] = factorial(n - 1).multiply(BigInteger.valueOf(n));
		}
		return tc[n];
	}
}
