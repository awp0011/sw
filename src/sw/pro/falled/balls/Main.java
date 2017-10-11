package sw.pro.falled.balls;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D, I, k;
		int T = Integer.parseInt(br.readLine());
		String[] testcase;
		for (int tc = 0; tc < T; tc++) {
			testcase = br.readLine().trim().split(" ");
			D = Integer.parseInt(testcase[0]);
			I = Integer.parseInt(testcase[1]) - 1;
			k = 1;
			for (int i = 0; i < D - 1; i++) {
				if ((I & 1) == 0) {
					k = (k << 1);
					I = ((I + 1) >> 1);
				} else {
					k = (k << 1) + 1;
					I = (I >> 1);
				}
			}
			System.out.println(k);
		}
	}
}
