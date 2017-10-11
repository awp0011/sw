package sw.pro.SDS_PRO_5_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source4 {
	static int	MN	= 1000 + 1;
	static int	MOD	= 100000000;

	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int cnt = 0; cnt < 10; cnt++) {
			String[] tc = br.readLine().split(" ");
			int N = Integer.parseInt(tc[1]);
			int K = Integer.parseInt(tc[2]);
			int[][][] D = new int[MN][MN][2];
			D[1][0][0] = D[1][0][1] = 1;
			for (int i = 2; i <= N; i++) {
				for (int k = 0; k <= i - 1 && k <= K; k++) {
					for (int b2 = 0; b2 <= 1; b2++) {
						for (int b1 = 0; b1 <= 1; b1++) {
							if (k - (b1 * b2) >= 0) {
								D[i][k][b2] += D[i - 1][k - (b1 * b2)][b1];
								D[i][k][b2] %= MOD;
							}
						}
					}
				}
			}
			System.out.println((D[N][K][0] + D[N][K][1]) % MOD);
			
		}
		br.close();
	}

}
