package sw.pro.fiveone;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class SolutionReview {
	private static long min;
	private static long max;
	private static int		counter;
	private static final char[]	startChars	= new char[34];
	private static final char[]	endChars	= new char[34];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
		        "C:\\Users\\Michael\\workspace\\java\\Examnation\\src\\sds\\sw\\certificert\\adv\\five\\one\\input.txt"));
		Scanner sc = new Scanner(System.in);
		long st = Calendar.getInstance().getTimeInMillis();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			scanNextTestcase(sc);
			min = findMin51();
			max = findMax51();
			if (max > min) {
				counter = findMiddle51();
			} else {
				min = -1;
				max = -1;
				counter = 0;
			}

			printResult(i + 1);
		}
		sc.close();
		long p = Calendar.getInstance().getTimeInMillis() - st;
		System.out.println("Use time: " + p);

	}

	private static void scanNextTestcase(Scanner sc) {
		long begin = sc.nextLong();
		long end = sc.nextLong();
		Arrays.fill(startChars, '0');
		Arrays.fill(endChars, '0');

		char[] temp = Long.toBinaryString(begin).toCharArray();
		int offset = startChars.length - temp.length;
		System.arraycopy(temp, 0, startChars, offset, temp.length);

		temp = Long.toBinaryString(end).toCharArray();
		offset = endChars.length - temp.length;
		System.arraycopy(temp, 0, endChars, offset, temp.length);

	}

	private static void printResult(int index) {
		System.out.println("#" + index + " " + min + " " + max + " " + counter);
	}

	private static int getAmountOf1(char[] aArray) {
		int amount = 0;
		for (char c : aArray) {
			if (c == '1')
				amount++;
		}
		return amount;
	}

	private static long findMin51() {
		int amount1 = getAmountOf1(startChars);
		if (amount1 < 5) {
			add1ToArray(startChars, amount1);
		} else {
			remove1FromArray(startChars, amount1);
			findNext51();
		}
		return Long.valueOf(new String(startChars), 2);
	}

	private static long findMax51() {
		int amount1 = getAmountOf1(endChars);
		if (amount1 < 5) {
			add1ToArray(endChars, amount1);
			findPrevious51();
		} else if (amount1 == 5) {
			findPrevious51();
		} else {
			remove1FromArray(endChars, amount1);

		}
		return Long.valueOf(new String(endChars), 2);
	}

	private static int findMiddle51() {
		int cnt = 0;
		while (!Arrays.equals(startChars, endChars)) {
			//System.out.print(Arrays.toString(start));
			//System.out.println("--" + Long.valueOf(new String(start), 2));
			findNext51();
			cnt++;
		}
		cnt--;
		return cnt;
	}

	private static void findPrevious51() {
		int left = 0;
		int right = endChars.length - 1;

		while (left != right) { // right first '10' --> '01'
			right--;
			if (endChars[right] == '1' && endChars[right + 1] == '0') {
				endChars[right + 1] = '1';
				endChars[right] = '0';
				left = right;
			}

		}
		right = endChars.length - 1;
		left += 2;
		while (left < right) {// 数组剩余部分 排序 1--->0
			if (endChars[left] != '0') {
				left++;
			}
			if (endChars[right] != '1') {
				right--;
			}
			if (endChars[left] == '0' && endChars[right] == '1') {
				endChars[left] = '1';
				endChars[right] = '0';
				left++;
				right--;
			}

		}
	}

	private static void findNext51() {
		int left = 0;
		int right = startChars.length - 1;

		while (left != right) { // right first '01' --> '10'
			right--;
			if (startChars[right] == '0' && startChars[right + 1] == '1') {
				startChars[right + 1] = '0';
				startChars[right] = '1';
				left = right;
			}

		}
		right = startChars.length - 1;
		left++;
		while (left < right) {// 数组剩余部分 排序 0--->1
			if (startChars[left] != '1') {
				left++;
			}
			if (startChars[right] != '0') {
				right--;
			}
			if (startChars[left] > startChars[right] && left < right) {
				startChars[left] = '0';
				startChars[right] = '1';
				left++;
				right--;
			}

		}
	}

	private static void add1ToArray(char[] aArray, int amount1) {
		int index = aArray.length - 1;
		while (amount1 != 5) {
			if (aArray[index] == '0') {
				aArray[index] = '1';
				amount1++;
			}
			index--;
		}
	}

	private static void remove1FromArray(char[] aArray, int amount1) {

		if (amount1 > 5) {
			int index = aArray.length - 1;
			while (amount1 != 5) {
				if (aArray[index] == '1' && amount1 > 5) {
					aArray[index] = '0';
					amount1--;
				}
				index--;
			}
		}
	}
}
