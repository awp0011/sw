package sw.pro.SUM;
/*
 * 递归
 * 数字可重复
 * ２＋１　和１＋２　是两种不同的拆分方式
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class source2 {
	static int[]	tc		= new int[201];
	static int[]	result	= new int[201];

	static int		MOD		= 1_000_000_000;
	static int		N, K;

	static int		Anwser;

	public static void main(String[] args) throws Exception {

		Arrays.fill(tc, -1);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		 sum(N, K);
		 System.out.println(Anwser);
		//sumNoRepeat(N, K);
		//System.out.println(Anwser);
	}

	static void sum(final int left_num, final int number_index) {
		if (number_index == 1 && left_num > -1 ) {
			// tc[1] = 1;
			result[number_index] = left_num;
			System.out.println(Arrays.toString(Arrays.copyOfRange(result, 1, K + 1)));
			Anwser++;
			if (Anwser > MOD) {
				Anwser = Anwser % MOD;
			}
		} else if (number_index > 1 && left_num > -1) {
			for (int i = 0; i <= N; i++) {
				result[number_index] = i;
				sum(left_num - i, number_index - 1);
			}
		}

	}

	

	static void sumDP() {

		int i, j, k;
		int f[][][] = new int[201][201][201];
		for (j = 0; j <= N; j++) {
			f[0][j][0] = 1;
		}
		for (k = 1; k <= K; k++) {
			for (j = 1; j <= N; j++) {
				for (i = j; i <= N; i++) {
					f[i][j][k] = f[i - j][j][k - 1] + f[i][j - 1][k];
				}
			}
		}
		System.out.println(f[N][N][K] % MOD);

	}
}
