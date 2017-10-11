package sw.pro.russian.dolls;

import java.util.Scanner;

class Source {
	static int[]	data	= new int[1001];
	static int		N, head = 1, tail, low, hight, middle;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] testcase;
		while (sc.hasNextInt()) {
			N = sc.nextInt();
			sc.nextLine();
			testcase = sc.nextLine().trim().split(" ");
			tail = 1;
			data[head] = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				getLIS(Integer.parseInt(testcase[i]));
			}

			System.out.println(tail);
		}
		sc.close();
	}

	static void getLIS(int num) {
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
}
