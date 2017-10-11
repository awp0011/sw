package sw.pro.road.pavement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	static int		N, M, answer;
	static int[]	villages;
	static int[][]	lines;
	static boolean	debug	= true;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		villages = new int[350];
		lines = new int[70000][3];
		String[] line;
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				line = br.readLine().trim().split(" ");
				lines[j][0] = Integer.parseInt(line[0]);
				lines[j][1] = Integer.parseInt(line[1]);
				lines[j][2] = Integer.parseInt(line[2]);
			}
			Arrays.sort(lines, 0, M, new Compare());

			if (debug) {
				System.out.println("#" + i + " " + N + " " + M);
				for (int n = 0; n < M; n++) {
					System.out.println(Arrays.toString(lines[n]));
				}
			} else {
				System.out.println("#" + i + " " + answer);
			}

		}
	}

	static class Compare implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[2] - o1[2];
		}
	}
}
