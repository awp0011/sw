package sw.pro.SDS_PRO_7_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class source_bak {
	static int			N;
	static Paper[][]	papers;

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(
				new FileReader(new File("/home/michael/eclipse-workspace/sw.pro/input/SDSS_PRO_7_4.tc")));
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
			Arrays.stream(row).forEach(p -> System.out.print(p.parnet.index + ","));
			System.out.println();
			zero += Arrays.stream(row).filter(p -> p.parnet.index == p.index && p.color == 0).count();
			one += Arrays.stream(row).filter(p -> p.parnet.index == p.index && p.color == 1).count();
		}
		System.out.println(zero);
		System.out.println(one);
	}

	static void cut() {
		// StringBuilder sb = new StringBuilder();
		int row = 0;
		int column = 0;
		int next_start = 0;
		int offset = 1;
		int block = 2;
		int tobeLevel = 1;
		while ((N >> tobeLevel) > 0) {
			// System.out.println("tobeLevel:" + tobeLevel + ",next_start:" + next_start);
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
						// sb.setLength(0);
						// sb.append("\tcheck->").append('(').append(start).append(',').append(i).append(')').append('-')
						// .append('(').append(start).append(',').append(i +
						// offset).append(')').append('-')
						// .append('(').append(start +
						// 1).append(',').append(i).append(')').append('-').append('(')
						// .append(start + 1).append(',').append(i + offset).append(')');
						// System.out.print(sb.toString());
						if (isQuadraSameColor(currPaper, offset) && isQuadraSameLevel(currPaper, offset)) {
							// to be union
							union(currPaper.parnet, nextPaper(currPaper, 1, offset));
							union(currPaper.parnet, nextPaper(currPaper, 2, offset));
							union(currPaper.parnet, nextPaper(currPaper, 3, offset));
							currPaper.parnet.unionLevel++;
							// System.out.println(",able to union");
						} else {
							// System.out.println(",unable to union");
						}
					}
					column += block;
				}
				row += block;
				// System.out.println("");
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
		if (cur.parnet.index == cur.index) {
			return cur;
		} else {
			return cur.parnet = find(cur.parnet);
		}
	}

	static void union(Paper p, Paper q) {
		if (p.unionSet == null) {
			p.unionSet = new HashSet<>();
		}
		p.unionSet.add(q);
		q.parnet.parnet = p;
		if (q.unionSet != null) {
			p.unionSet.addAll(q.unionSet);
		}

	}

	static class Paper {
		int			X, Y;
		int			index;
		int			color;
		Paper		parnet;
		int			unionLevel	= 1;
		Set<Paper>	unionSet;

		Paper(int x, int y, int c) {
			X = x;
			Y = y;
			color = c;
			index = X * N + y;
			parnet = this;
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
			return parnet.unionLevel;
		}
	}
}