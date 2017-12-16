package sw.pro.SDS_PRO_1_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	private static int M, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Box[][] board = new Box[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = new Box(i, j, Integer.parseInt(st.nextToken()));
				if (i > 0) {
					unionFind(board[i][j], board[i - 1][j]);
				}
				if (j > 0) {
					unionFind(board[i][j], board[i][j - 1]);
				}
			}
		}
		br.close();
		int first_row_black_cnt = (int) Arrays.stream(board[0]).filter(b -> b.equals(b.parent)&&b.color==0).count();
		int answer = N - first_row_black_cnt > first_row_black_cnt ? first_row_black_cnt : N - first_row_black_cnt;
		System.out.println(answer);

	}

	private static void unionFind(final Box p, final Box q) {

		if (p.color != q.color)
			return;
		if (find(p).equals(find(q)))
			return;
		if (p.parent.index < q.parent.index) {
			q.parent = p.parent;
		} else {
			p.parent = q.parent;
		}
	}

	private static Box find(final Box box) {
		if (box.equals(box.parent))
			return box.parent;
		return box.parent = find(box.parent);
	}

	private static class Box {
		int	index;
		int	color;
		Box	parent;

		Box(final int i, final int j, final int c) {
			index = i * M + j;
			color = c;
			parent = this;
		}

		boolean equals(final Box other) {
			return other != null && other.index == index;
		}
	}
}