package sw.pro.russian.dolls;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source2 {

	public static void main(String[] args) throws Exception {
		int[] data = new int[1001];
		int N, num, head, tail, low, hight, middle;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] testcase;
		N = Integer.parseInt(line);
		testcase = br.readLine().trim().split(" ");
		head = tail = 1;
		data[head] = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(testcase[i]);
			if (num < data[head]) {
				data[head] = num;
			} else if (num > data[tail]) {
				tail++;
				data[tail] = num;
			} else {
				low = head;
				hight = tail;
				while (low < hight) {
					middle = (low + hight) >> 1;
					if (num > data[middle]) {
						low = middle + 1;
					} else {
						hight = middle;
					}
				}
				data[hight] = num;
			}
		}
		System.out.println(tail);
		br.close();
	}
}