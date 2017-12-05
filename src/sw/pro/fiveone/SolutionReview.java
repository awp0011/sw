package sw.pro.fiveone;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class SolutionReview {
	static long		begin, end, min, max;
	static int		counter;
	static char[]	startChars	= new char[34];
	static char[]	endChars	= new char[34];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
		        "C:\\Users\\Michael\\workspace\\java\\Examnation\\src\\sds\\sw\\certificert\\adv\\five\\one\\input.txt"));
		Scanner sc = new Scanner(System.in);
		long st = Calendar.getInstance().getTimeInMillis();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			scanNextTestcase(sc);
			min = findMin51(startChars);
			max = findMax51(endChars);
			if (max > min) {
				counter = findMiddle51(startChars, endChars);
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

	static void scanNextTestcase(Scanner sc) {
		begin = sc.nextLong();
		end = sc.nextLong();
		Arrays.fill(startChars, '0');
		Arrays.fill(endChars, '0');

		char[] temp = Long.toBinaryString(begin).toCharArray();
		int offset = startChars.length - temp.length;
		for (int index = 0; index < temp.length; index++) {
			startChars[index + offset] = temp[index];
		}

		temp = Long.toBinaryString(end).toCharArray();
		offset = endChars.length - temp.length;
		for (int index = 0; index < temp.length; index++) {
			endChars[index + offset] = temp[index];
		}

	}

	static void printResult(int index) {
		System.out.println("#" + index + " " + min + " " + max + " " + counter);
	}

	static int getAmountOf1(char[] aArray) {
		int amount = 0;
		for (char c : aArray) {
			if (c == '1')
				amount++;
		}
		return amount;
	}

	static long findMin51(char[] aArray) {
		int amount1 = getAmountOf1(aArray);
		if (amount1 < 5) {
			add1ToArray(aArray, amount1);
		} else {
			remove1FromArray(aArray, amount1);
			findNext51(aArray);
		}
		return Long.valueOf(new String(aArray), 2);
	}

	static long findMax51(char[] aArray) {
		int amount1 = getAmountOf1(aArray);
		if (amount1 < 5) {
			add1ToArray(aArray, amount1);
			findPrevious51(aArray);
		} else if (amount1 == 5) {
			findPrevious51(aArray);
		} else {
			remove1FromArray(aArray, amount1);

		}
		return Long.valueOf(new String(aArray), 2);
	}

	static int findMiddle51(char[] start, char[] end) {
		int cnt = 0;
		while (!Arrays.equals(start, end)) {
			//System.out.print(Arrays.toString(start));
			//System.out.println("--" + Long.valueOf(new String(start), 2));
			findNext51(start);
			cnt++;
		}
		cnt--;
		return cnt;
	}

	static void findPrevious51(char[] aArray) {
		int left = 0;
		int right = aArray.length - 1;

		while (left != right) { // right first '10' --> '01'
			right--;
			if (aArray[right] == '1' && aArray[right + 1] == '0') {
				aArray[right + 1] = '1';
				aArray[right] = '0';
				left = right;
			}

		}
		right = aArray.length - 1;
		left += 2;
		while (left < right) {// 数组剩余部分 排序 1--->0
			if (aArray[left] != '0') {
				left++;
			}
			if (aArray[right] != '1') {
				right--;
			}
			if (aArray[left] == '0' && aArray[right] == '1') {
				aArray[left] = '1';
				aArray[right] = '0';
				left++;
				right--;
			}

		}
	}

	static void findNext51(char[] aArray) {
		int left = 0;
		int right = aArray.length - 1;

		while (left != right) { // right first '01' --> '10'
			right--;
			if (aArray[right] == '0' && aArray[right + 1] == '1') {
				aArray[right + 1] = '0';
				aArray[right] = '1';
				left = right;
			}

		}
		right = aArray.length - 1;
		left++;
		while (left < right) {// 数组剩余部分 排序 0--->1
			if (aArray[left] != '1') {
				left++;
			}
			if (aArray[right] != '0') {
				right--;
			}
			if (aArray[left] > aArray[right] && left < right) {
				aArray[left] = '0';
				aArray[right] = '1';
				left++;
				right--;
			}

		}
	}

	static void add1ToArray(char[] aArray, int amount1) {
		int index = aArray.length - 1;
		while (amount1 != 5) {
			if (aArray[index] == '0') {
				aArray[index] = '1';
				amount1++;
			}
			index--;
		}
	}

	static void remove1FromArray(char[] aArray, int amount1) {

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
