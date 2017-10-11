package sw.pro.SDS_PRO_9_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source3 {
	static Cell[][]	testcase	= new Cell[105][105];
	static Cell[]	stack		= new Cell[105];
	static int		T, M, N;
	static int		paper_cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		String[] tempArr;
		char[] tempCharArr;
		for (int tc = 0; tc < T; tc++) {

			tempArr = br.readLine().trim().split(" ");
			N = Integer.parseInt(tempArr[0]);
			M = Integer.parseInt(tempArr[1]);
			for (int i = 1; i <= M; i++) {
				tempCharArr = br.readLine().trim().toCharArray();
				// System.out.println(Arrays.toString(tempCharArr));
				for (int j = 1; j <= N; j++) {
					testcase[i][j] = new Cell(i, j, tempCharArr[j - 1]);
				}
			}

			// 第一次遍历所有的可能性
			gotoMN(testcase[1][1], 0);
			System.out.println(paper_cnt);
			paper_cnt = 0;
		}


	}

	static void gotoMN(Cell start, int head) {
		int stack_head = head;
		if (start.isPaper()) {
			stack_head++;
			stack[stack_head] = start;
		}
		if (start.equals(testcase[M][N])) {
			for (int u = 1; u <= stack_head; u++) {
				stack[u].setEmpty();
			}
			// goto (1,1)
			goto11(testcase[M][N], stack_head);

			// 恢复
			for (int u = 1; u <= stack_head; u++) {
				stack[u].setPaper();
			}
		} else {
			int move2Right = start.y + 1;
			if (move2Right <= N && !testcase[start.x][move2Right].isSharp()) {
				gotoMN(testcase[start.x][move2Right], stack_head);

			}
			int move2Down = start.x + 1;
			if (move2Down <= M && !testcase[move2Down][start.y].isSharp()) {
				gotoMN(testcase[move2Down][start.y], stack_head);
			}
		}

	}

	static void goto11(Cell start, int head) {
		int stack_head = head;
		if (start.isPaper()) {
			stack_head++;
			stack[stack_head] = start;
		}
		if (start.equals(testcase[1][1])) {
			paper_cnt = stack_head > paper_cnt ? stack_head : paper_cnt;
		} else {
			int move2Left = start.y - 1;
			if (move2Left >= 1 && !testcase[start.x][move2Left].isSharp()) {
				goto11(testcase[start.x][move2Left], stack_head);

			}
			int move2Up = start.x - 1;
			if (move2Up >= 1 && !testcase[move2Up][start.y].isSharp()) {
				goto11(testcase[move2Up][start.y], stack_head);
			}
		}

	}

	static class Cell {
		int		x, y;
		char	type;

		public Cell(final int a, final int b, final char t) {
			x = a;
			y = b;
			type = t;
		}

		boolean equals(Cell other) {
			return other != null && other.x == x && other.y == y;
		}

		boolean isPaper() {
			return '*' == type;
		}

		boolean isSharp() {
			return '#' == type;
		}

		void setEmpty() {
			type = '.';
		}

		void setPaper() {
			type = '*';
		}
	}
}
