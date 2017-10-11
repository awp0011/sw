package sw.pro.SDS_PRO_9_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class source5 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] roads = new int[100 + 1][100 + 1];

		for (int t = 0; t < T; t++) {
			String[] tempArr = br.readLine().trim().split(" ");
			int M = Integer.parseInt(tempArr[1]);
			int N = Integer.parseInt(tempArr[0]);
			for (int m = 1; m < M + 1; m++) {
				String line = br.readLine();
				for (int n = 1; n < N + 1; n++) {
					roads[m][n] = line.charAt(n - 1);
				}
			}
			/**
			 * D(i,j,k) i는 가로 or 세로를 이동하여 움직인 총 turn수 j는 내려가면서 폐지를 줍는 사람의 x 좌표 k는 올라가면서 폐지를
			 * 줍는 사람의 x 좌표 ( 내려가고 올라가고 하는 두번의 동작을 time series로 선행 후행 따지지 말고 그냥 상태를 하기 위해서 그냥
			 * 같이 내려가면서 줍는걸로 역발상!!
			 */
			int D[][][] = new int[200 + 1][100 + 1][100 + 1];

			// '*'는 갈 수 있으며 폐지가 있는 곳을 나타낸다.
			// '.'는 갈 수 있지만 폐지가 없는 곳을 나타낸다.
			// '#'는 갈 수 없는 곳을 나타낸다.

			for (int i = 1; i < M + N; i++) {
				for (int j = 1; j < M; j++) {//x
					for (int k = 1; k < N; k++) {//y
						if (k > i || j > k)
							continue;

						if (i == 0 && j == 0 && k == 0)
							D[i][j][k] = 0;
						if (i == 1 && roads[0][0] == '*')
							D[i][j][k] = 1;

						// 지금 현재 i번째 대각선의 j번째 x좌표의 그 포인트에서 가장 많이 폐지를 주울 수 있는 가지수!
						// 现在i /第j次对角线的x坐标的点上，给废纸的最多数量。
						D[i][j][k] = Math.max(Math.max(D[i - 1][j - 1][k], D[i - 1][j][k]),
								Math.max(D[i - 1][j][k - 1], D[i - 1][j][k]));
						System.out.println(D[i][j][k]);
					}
				}
			}
			System.out.println();
		}
		br.close();
	}
}