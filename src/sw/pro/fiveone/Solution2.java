package sw.pro.fiveone;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Solution2 {
	static long		start;
	static long		end;
	static int		counter;
	static char[]	lastest_51	= new char[34];
	static char[]	first_51	= new char[34];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
		        "C:\\Users\\Michael\\workspace\\java\\Examnation\\src\\sds\\sw\\certificert\\adv\\five\\one\\input.txt"));
		Scanner sc = new Scanner(System.in);
		long st = Calendar.getInstance().getTimeInMillis();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			scanNextTestcase(sc);
			findLast51(lastest_51);
			// System.out.println("max:" + Arrays.toString(lastest_51));
			end = Long.valueOf(new String(lastest_51), 2);

			findFirst51(first_51);
			// System.out.println("min:" + Arrays.toString(first_51));
			start = Long.valueOf(new String(first_51), 2);

			if (start >= end) {
				start = -1;
				end = -1;
				counter = 0;
			} else {
				findOther51();
			}
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
		Arrays.fill(first_51, '0');
		Arrays.fill(lastest_51, '0');
		char[] charSeq = Long.toBinaryString(start).toCharArray();
		int offset = first_51.length - charSeq.length;
		for (int index = 0; index < charSeq.length; index++) {
			first_51[index + offset] = charSeq[index];
		}
		charSeq = Long.toBinaryString(end).toCharArray();
		offset = lastest_51.length - charSeq.length;
		for (int index = 0; index < charSeq.length; index++) {
			lastest_51[index + offset] = charSeq[index];
		}
		// System.out.println("first:" + Arrays.toString(first_51));
		// System.out.println("lastest:" + Arrays.toString(lastest_51));
		add1(lastest_51);

		// System.out.println("first :" + Arrays.toString(first_51));
		// System.out.println("lastest :" + Arrays.toString(lastest_51));
	}

	static void add1(char[] number) {
		int amountOf1 = 5 - (new String(number)).replaceAll("0", "").length();
		int index = number.length - 1;
		while (amountOf1 > 0 && index >= 0) {
			if (number[index] == '0') {
				number[index] = '1';
				amountOf1 -= 1;
			}
			index -= 1;
		}
	}

	static void printResult(int index) {
		System.out.println("#" + index + " " + start + " " + end + " " + counter);
	}

	static void findLast51(char[] max) {

		int temp = (new String(max)).replaceAll("0", "").length();
		if (temp == 5) {// 从右向左找到第一个（10）然后交换为（01）
			int index = max.length - 1;
			boolean isSwap = true;
			while (isSwap && index > 0) {
				index -= 1;
				if (max[index] == '1' && max[index + 1] == '0') {
					max[index] = '0';
					max[index + 1] = '1';
					isSwap = false;
				}
			}
			index += 1;
			int indexOfchanged = max.length - 1;

			// System.out.println("Before:" + Arrays.toString(first_51));

			while (index < indexOfchanged && !isSwap) {

				if (max[index] != '0') {
					index += 1;
				}
				if (max[indexOfchanged] != '1') {
					indexOfchanged -= 1;
				}
				if (max[index] < max[indexOfchanged]) {
					max[index] = '1';
					max[indexOfchanged] = '0';
					index += 1;
					indexOfchanged -= 1;
				}

			}
		} else {// 将第五个1 后的1全部置为0
			int amountOf1 = 0;
			for (int i = 0; i < max.length; i++) {
				if (max[i] == '1') {
					amountOf1 += 1;
					if (amountOf1 > 5) {
						max[i] = '0';
					}
				}

			}
		}

	}

	static void findFirst51(char[] min) {
		int temp = (new String(min)).replaceAll("0", "").length();

		if (temp == 5) {
			findNext51(min);
		} else if (temp > 5) {
			findLast51(min);
			findNext51(min);
		} else {
			add1(min);
		}

	}

	static void findNext51(char[] current) {
		int rightFirstPosOf1 = -1;
		int pos0LeftFirst1 = -1;
		int index = current.length - 1;
		while (rightFirstPosOf1 == -1 && index >= 0) {
			if (current[index] == '1') {
				rightFirstPosOf1 = index;
			}
			index -= 1;
		}
		while (pos0LeftFirst1 == -1 && index >= 0) {
			if (current[index] == '0') {
				pos0LeftFirst1 = index;
			}
			index -= 1;

		}
		if (rightFirstPosOf1 != -1) {
			current[rightFirstPosOf1] = '0';
		}
		if (pos0LeftFirst1 != -1) {
			current[pos0LeftFirst1] = '1';
		}
		pos0LeftFirst1 += 1;

		int indexOfchanged = current.length - 1;

		// System.out.println("Before:" + Arrays.toString(first_51));

		while (pos0LeftFirst1 < indexOfchanged) {

			if (current[pos0LeftFirst1] != '1') {
				pos0LeftFirst1 += 1;
			}
			if (current[indexOfchanged] != '0') {
				indexOfchanged -= 1;
			}
			if (current[pos0LeftFirst1] > current[indexOfchanged]) {
				current[pos0LeftFirst1] = '0';
				current[indexOfchanged] = '1';
				pos0LeftFirst1 += 1;
				indexOfchanged -= 1;
			}

		}
		// System.out.println("After:" + Arrays.toString(first_51));

	}

	static void findOther51() {
		while (!Arrays.equals(first_51, lastest_51)) {
			counter += 1;
			findNext51(first_51);
			// System.out.println("--" + Arrays.toString(first_51));
		}
		counter -= 1;// 最大值与最小值之间多少个5个1
	}
}
