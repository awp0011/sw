package sw.pro.PARTY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class source {
	static int[][]				dp;

	static LinkedList<Integer>	queue	= new LinkedList<>();
	static int[][]				data;
	static int[][]				isVisited;
	static int					N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int INF = 30_000_000;
		N = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][N + 1];
		isVisited = new int[N + 1][N + 1];

		int M = Integer.parseInt(st.nextToken());
		data = new int[N + 1][N + 1];

		int T = Integer.parseInt(st.nextToken());
		Arrays.fill(dp[1], INF);
		Arrays.fill(dp[T], INF);
		int s, e, t;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			data[s][e] = t;
			dp[s][e] = t;
		}
		queue.add(1);

		bfs(1, T, 1);

		if (isVisited[1][T] != 1) {
			System.out.println("NO");
		} else {

			queue.add(T);
			bfs(T, 1, -1);

			if (isVisited[T][1] != -1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				System.out.println(dp[1][T] + dp[T][1]);
			}
		}

		// System.out.println("------dp array------");
		// Arrays.stream(dp).forEach(arr -> {
		// System.out.println(Arrays.toString(arr));
		// });
		// System.out.println("------data array------");
		// Arrays.stream(data).forEach(arr -> {
		// System.out.println(Arrays.toString(arr));
		// });
	}

	static void bfs(final int begin, final int target, final int visited) {
		int start = 0;

		while (queue.size() != 0) {
			start = queue.poll().intValue();
			for (int i = 1; i <= N; i++) {
				if (data[start][i] > 0 && i != begin) {
					if (isVisited[start][i] != visited) {
						isVisited[start][i] = visited;
						if (i != target) {
							// System.out.print(i + "(" + start + ")-->");
							queue.add(i);
						} else {
							isVisited[begin][target] = visited;
						}
					}

					if (dp[begin][i] > dp[begin][start] + dp[start][i]) {
						dp[begin][i] = dp[begin][start] + dp[start][i];
					}

				}
			}
		}
		// System.out.println();
	}

}