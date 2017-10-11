package sw.pro.russian.dolls;

import java.util.Arrays;

/* 最长递增子序列 LIS
 * 设数组长度不超过 30
 * DP
*/
class source_lis_dp {
	static int[]	dp	= new int[300_001];	/* dp[i]记录到[0,i]数组的LIS */
	static int		lis;					/* LIS 长度 */

	static int LIS(int[] arr, int size) {
		for (int i = 0; i < size; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					if (dp[i] > lis) {
						lis = dp[i];
					}
				}
			}
			System.out.println(Arrays.toString(Arrays.copyOf(dp, arr.length)));
		}
		return lis;
	}

	/* 输出LIS 为了正序输出LIS序列采用了小技巧 */
	static void outputLIS(int[] arr, int index) {
		boolean isLIS = false;
		if (index < 0 || lis == 0) {
			return;
		}
		if (dp[index] == lis) {
			--lis;
			isLIS = true;
		}

		outputLIS(arr, --index);

		if (isLIS) {
			System.out.print(arr[index + 1] + " ");
		}
	}

	public static void main(String[] args) {

		//int arr[] = { 1, -1, 2, -3, 4, -5, 6, -7 };
		//int arr[] = {1, 1, 2, 2, 3, 3, 2, 2, 5, 5};
		int arr[] = {1, 6, 2, 5, 7, 3, 5, 6};
		/* 输出LIS长度； sizeof 计算数组长度 */
		System.out.println(LIS(arr, arr.length));

		/* 输出LIS */
		
		outputLIS(arr, arr.length - 1);
		System.out.println();
	}
}