package sw.pro.SDS_PRO_4_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class source2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] fields = new int[N + 1][N + 1];
		int[] cow = new int[K + 1];

		for (int i = 1; i <= K; i++) {
			cow[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			fields[i][i] = 1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			fields[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j && fields[i][j] == 1) {
					for (int n = 1; n <= N; n++) {
						fields[i][n] = fields[i][n] | fields[j][n];
					}
				}
				// System.out.print(i+","+j+"--");
				// System.out.println(Arrays.toString(Arrays.copyOf(fields[i], N + 1)));
			}
			System.out.println("--" + Arrays.toString(Arrays.copyOf(fields[i], N + 1)));
		}
		int[] answer = new int[N + 1];
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				answer[j] += fields[cow[i]][j];
			}
		}
		System.out.println(Arrays.stream(answer).filter(i -> i == K).count());
		// System.out.println(Arrays.toString(Arrays.copyOf(glass, N + 1)));

	}

}