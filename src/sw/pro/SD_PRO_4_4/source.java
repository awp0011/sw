package sw.pro.SD_PRO_4_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class source {

	public static void main(String[] args) throws Exception {
		ArrayList<Edge> edges = new ArrayList<>(10000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N, M, W;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			int s, e, t;
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				edges.add(new Edge(s, e, t));
				edges.add(new Edge(e, s, t));
			}
			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				edges.add(new Edge(s, e, -t));
			}

			if (hasNegative(N + 1, edges)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			edges.clear();
		}
		br.close();

	}

	static boolean hasNegative(int n, ArrayList<Edge> edges) {
		int[] arrN = new int[n];
		Arrays.fill(arrN, Integer.MAX_VALUE);
		arrN[1] = 0;
		boolean updated;
		for (int i = 0; i < n; i++) {
			updated = false;
			for (Edge e : edges) {
				if (arrN[e.end] > arrN[e.start] + e.time) {
					arrN[e.end] = arrN[e.start] + e.time;
					updated = true;
				}
			}
			if (!updated) {
				return false;
			}
		}

		return true;
	}

	static class Edge {
		int start, end, time;

		Edge(final int s, final int e, final int t) {
			start = s;
			end = e;
			time = t;
		}
	}
}