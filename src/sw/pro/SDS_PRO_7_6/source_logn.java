package sw.pro.SDS_PRO_7_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source_logn {
	static long MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(climbStairs(Integer.parseInt(br.readLine())));
		br.close();
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
