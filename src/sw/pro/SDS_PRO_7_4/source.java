package sw.pro.SDS_PRO_7_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	static int			N;
	static Paper[][]	papers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		papers = new Paper[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				papers[i][j] = new Paper(i, j, Integer.parseInt(st.nextToken()));
			}
		}
		br.close();
		cut();
		int zero = 0, one = 0;
		Arrays.stream(papers).forEach(row -> Arrays.stream(row).forEach(cell -> find(cell)));

		for (Paper[] row : papers) {
			// Arrays.stream(row).forEach(p -> System.out.print(p.parnet.index + ","));
			// System.out.println();
			zero += Arrays.stream(row).filter(p -> p.parent.index == p.index && p.color == 0).count();
			one += Arrays.stream(row).filter(p -> p.parent.index == p.index && p.color == 1).count();
		}
		System.out.println(zero);
		System.out.println(one);
	}

	static void cut() {
		int row = 0;
		int column = 0;
		int next_start = 0;
		int offset = 1;
		int block = 2;
		int tobeLevel = 1;
		while ((N >> tobeLevel) > 0) {
			row = next_start;
			while (row < N) {
				column = 0;
				while (column < N) {
					Paper currPaper = papers[row][column];
					find(nextPaper(currPaper, 0, offset));
					find(nextPaper(currPaper, 1, offset));
					find(nextPaper(currPaper, 2, offset));
					find(nextPaper(currPaper, 3, offset));
					if (currPaper.getUnionLevel() == tobeLevel) {
						if (isQuadraSameColor(currPaper, offset) && isQuadraSameLevel(currPaper, offset)) {
							union(currPaper.parent, nextPaper(currPaper, 1, offset));
							union(currPaper.parent, nextPaper(currPaper, 2, offset));
							union(currPaper.parent, nextPaper(currPaper, 3, offset));
							currPaper.parent.unionLevel++;
						}
					}
					column += block;
				}
				row += block;
			}
			next_start += Math.pow(2, tobeLevel - 1);
			block = block << 1;
			offset = offset << 1;
			tobeLevel++;
		}

	}

	static boolean isQuadraSameColor(Paper p, int offset) {
		return nextPaper(p, 0, offset).isSameColor(nextPaper(p, 1, offset))
				&& nextPaper(p, 0, offset).isSameColor(nextPaper(p, 2, offset))
				&& nextPaper(p, 0, offset).isSameColor(nextPaper(p, 3, offset));
	}

	static Paper nextPaper(Paper p, int position, int offset) {
		if (position == 0) {
			return papers[p.X][p.Y];
		} else if (position == 1) {
			return papers[p.X][p.Y + offset];
		} else if (position == 2) {
			return papers[p.X + 1][p.Y];
		} else {
			return papers[p.X + 1][p.Y + offset];
		}

	}

	static boolean isQuadraSameLevel(Paper p, int offset) {
		return nextPaper(p, 0, offset).getUnionLevel() == nextPaper(p, 1, offset).getUnionLevel()
				&& nextPaper(p, 0, offset).getUnionLevel() == nextPaper(p, 2, offset).getUnionLevel()
				&& nextPaper(p, 0, offset).getUnionLevel() == nextPaper(p, 3, offset).getUnionLevel();
	}

	static Paper find(Paper cur) {
		if (cur.parent.index == cur.index) {
			return cur;
		} else {
			return cur.parent = find(cur.parent);
		}
	}

	static void union(Paper p, Paper q) {
		q.parent.parent = p;
	}

	static class Paper {
		int		X, Y;
		int		index;
		int		color;
		int		unionLevel	= 1;
		Paper	parent;

		Paper(int x, int y, int c) {
			X = x;
			Y = y;
			color = c;
			index = X * N + y;
			parent = this;
		}

		boolean equals(Paper o) {
			if (o == null)
				return false;
			return index == o.index;

		}

		boolean isSameColor(Paper o) {
			return color == o.color;
		}

		int getUnionLevel() {
			return parent.unionLevel;
		}
	}
}