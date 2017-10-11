package sw.pro.lis;
//LONGEST_INCREASING_SUBSEQUENCE

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	static int[] lis = new int[300_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int head = 1;
		int tail = 1;
		int num, low, hight, middle = 0;
		Arrays.fill(lis, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (num < lis[head]) {
				lis[head] = num;
			} else if (num > lis[tail]) {
				tail++;
				lis[tail] = num;
			} else {
				low = head;
				hight = tail;
				while (low < hight) {
					middle = (low + hight) >> 1;
					if (num < lis[middle]) {
						hight = middle;
					} else {
						low = middle + 1;
					}
				}
				lis[hight] = num;
			}
		}
		System.out.println(tail);
	}

}
