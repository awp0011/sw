package sw.pro.KOI_2008RH_AMEOBA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] testcase = br.readLine().trim().split(" ");
		 int		ADULT, BAN, DEAD, N;
		 int[][]	pool	= new int[1_000_01][2];	// [total][new]
		ADULT = Integer.parseInt(testcase[0]);
		BAN = Integer.parseInt(testcase[1]);
		DEAD = Integer.parseInt(testcase[2]);
		N = Integer.parseInt(testcase[3]);

		pool[0][0] = 1;
		pool[0][1] = 1;
		pool[DEAD][1] = -1;
		int born_start, born_end;
		for (int i = 1; i <= N; i++) {
			born_end = i - BAN;
			born_start = i - ADULT;
			while (born_start >= 0 && born_start > born_end) {
				pool[i][1] += pool[born_start][1];
				born_start--;
			}
			for (int j = born_end; j > born_start; j--) {
				pool[i][1] += pool[j][1];
				pool[i + DEAD][1] -= pool[j][1];
			}
			pool[i][1] = (pool[i][1] + 1000) % 1000;
			pool[i + DEAD][1] = (pool[i + DEAD][1] + 1000) % 1000;
			pool[i][0] += pool[i - 1][0] // before day total
					+ pool[i][1];// today new
			pool[i][0] = (pool[i][0] + 1000) % 1000;
		}
		System.out.println(pool[N][0]);
		br.close();
	}

}
