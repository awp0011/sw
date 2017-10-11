package sw.pro.SDS_PRO_6_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class source2 {
	static int		MAX	= 201;
	static int[][]	d	= new int[MAX][MAX];
	static int[][]	t	= new int[MAX][MAX];
	static int[][]	h	= new int[MAX][MAX];
	static int[]	r	= new int[MAX];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] a = br.readLine().toCharArray();
		int i, j, k, l;

		for (i = 0; i < n; i++) {
			Arrays.fill(d[i], 0, n, -1);// 所有棋子间未连接
		}
		// 初始化 高度１ 长度３的数据
		for (i = 0; i + 1 < n; i++) {
			if (a[i] != a[i + 1]) {
				d[i][i + 1] = 3;// 长度３
				h[i][i + 1] = 1;// 高度１
				t[i][i + 1] = -1;// 连接的意思?
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; i + j < n; j++) {
				k = j + i;
				if (a[j] != a[k]) {
					if (d[j + 1][k - 1] == -1) {
						continue;
					}
					// 计算每次连接长度：
					// d[j + 1][k - 1] 已经连接的长度
					// (k - j) 两个棋子间的距离
					// (h[j + 1][k - 1] + 1) * 2 连接棋子的高度
					d[j][k] = d[j + 1][k - 1] + (k - j) + (h[j + 1][k - 1] + 1) * 2;
					System.out.println("d[" + j + "][" + k + "] = d[" + (j + 1) + "][" + (k - 1) + "]+" + (k - j)
							+ "+(h[" + (j + 1) + "][" + (k - 1) + "] + 1) * 2");
					// 高度加１
					h[j][k] = h[j + 1][k - 1] + 1;
					System.out.println("h[" + j + "][" + k + "] = h[" + (j + 1) + "][" + (k - 1) + "] + 1");
					// j k 连接了?
					t[j][k] = -1;
					System.out.println("t[" + j + "][" + k + "] = -1");
					System.out.println();
		
				}
				for (l = j + 1; l < k; l++) {
					if (d[j][l] == -1 || d[l + 1][k] == -1) {
						continue;
					}
					if (d[j][k] == -1 || d[j][k] > d[j][l] + d[l + 1][k]) {
						d[j][k] = d[j][l] + d[l + 1][k];
						System.out.println(
								"d[" + j + "][" + k + "] = d[" + j + "][" + l + "]+d[" + (l + 1) + "][" + k + "]");
						h[j][k] = h[j][l];
						System.out.println("h[" + j + "][" + k + "] = h[" + j + "][" + l + "] ");
						if (h[j][k] < h[l + 1][k]) {
							h[j][k] = h[l + 1][k];
						}
						System.out.println("t[" + j + "][" + k + "] = "+l);
						t[j][k] = l;
						System.out.println();
						System.out.println("-------"); 
					}
				}
			}
		}

		System.out.println(d[0][n - 1]);
		/*
		 * trace(0, n - 1); for (i = 0; i < n; i++) { if (i < r[i]) {
		 * System.out.println((i + 1) + " " + (r[i] + 1)); } }
		 */
	}

	static void trace(int f, int l) {
		if (f < l) {
			if (t[f][l] == -1) {
				r[f] = l;
				r[l] = f;
				trace(f + 1, l - 1);
			} else {
				trace(f, t[f][l]);
				trace(t[f][l] + 1, l);
			}
		}
	}
}
