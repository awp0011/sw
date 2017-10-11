package sw.pro.KOI_2008RH_AMEOBA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] testcase = br.readLine().trim().split(" ");

		int a, b, d, N;
		a = Integer.parseInt(testcase[0]);
		b = Integer.parseInt(testcase[1]);
		d = Integer.parseInt(testcase[2]);
		N = Integer.parseInt(testcase[3]);

		int[] Live = new int[1000003];
		int[] Born = new int[1000003];
		int[] Sum = new int[1000003];

		Born[0] = 1;
		Live[0] = 1;
		Sum[0] = 1;

		for (int i = 1; i <= N; i++) {
			if (i >= a) {
				Born[i] = Sum[i - a];
			}
			if (i >= b) {
				Born[i] -= Sum[i - b];
			}

			Sum[i] = Sum[i - 1] + Born[i];
			Live[i] = Live[i - 1] + Born[i];

			if (i >= d) {
				Live[i] -= Born[i - d];
			}

			Live[i] = (Live[i] + 1000) % 1000;
			Born[i] = (Born[i] + 1000) % 1000;
			Sum[i] = (Sum[i] + 1000) % 1000;
		}
		System.out.println(Live[N]);
		br.close();
	}

}
