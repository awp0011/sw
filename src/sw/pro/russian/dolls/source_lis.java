package sw.pro.russian.dolls;

import java.util.Arrays;

public class source_lis {
	// static int[][] dp = new int[1005][1005];
	static int[][] dp = new int[9][9];

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static void qsort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int index = left;
		for (int i = left + 1; i <= right; ++i) {
			if (arr[i] < arr[left]) {
				swap(arr, ++index, i);
			}
		}
		swap(arr, index, left);
		qsort(arr, left, index - 1);
		qsort(arr, index + 1, right);
	}

	static int LCS(int[] arr, int[] arrcopy, int len) {
		for (int i = 1; i <= len; ++i) {
			for (int j = 1; j <= len; ++j) {
				if (arr[i - 1] == arrcopy[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[len][len];
	}

	public static void main(String[] args) {

		int[] arr = { 1, -1, 2, -3, 4, -5, 6, -7 };
		int[] arrcopy = Arrays.copyOf(arr, arr.length);
		qsort(arrcopy, 0, arr.length - 1);

		/* 计算LCS，即LIS长度 */
		int len = arr.length;
		System.out.println(LCS(arr, arrcopy, len));

		for (int[] a : dp) {
			System.out.println(Arrays.toString(a));
		}
	}
}
