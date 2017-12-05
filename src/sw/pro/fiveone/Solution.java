package sw.pro.fiveone;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Scanner;

public class Solution {
	static long	start, end, min, max;
	static int	counter;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
		        "C:\\Users\\Michael\\workspace\\java\\Examnation\\src\\sds\\sw\\certificert\\adv\\five\\one\\input.txt"));
		Scanner sc = new Scanner(System.in);
		long st = Calendar.getInstance().getTimeInMillis();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			scanNextTestcase(sc);
			find51();

			printResult(i + 1);
		}
		sc.close();
		long p = Calendar.getInstance().getTimeInMillis() - st;
		System.out.println("Use time: " + p);

	}

	static void scanNextTestcase(Scanner sc) {
		start = sc.nextLong();
		end = sc.nextLong();
		counter = 0;
		min = 0;
		max = 0;
	}

	static void printResult(int index) {
		System.out.println("#" + index + " " + min + " " + max + " " + counter);
	}

	static void find51() {
		start++;
		end--;
		while (start <= end) {

			if (Long.toBinaryString(start).replaceAll("0", "").length() == 5) {
				if (min == 0) {
					min = start;
				} else {
					max = start;
				}
				System.out.println("-"+start+"-"+Long.toBinaryString(start));
				counter++;
			}
			start++;
		}
		counter -= 2;// 最大值与最小值之间多少个5个1
		if (counter < 0) {
			counter = 0;
			min = 0;
			max = 0;
		}
	}
}
