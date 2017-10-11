package sw.pro.Exponentiation;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// System.out.println(validation("95.123", 12));
		// System.out.println(validation("0.4321", 20));
		Scanner sc = new Scanner(System.in);
		String R;
		int n;
		while (sc.hasNext()) {
			R = sc.next();
			n = sc.nextInt();
			// 0.0 < R < 99.999， 0 < n <= 25，
			double d = Double.parseDouble(R);
			if (d > 0 && d < 99.999 && n > 0 && n <= 25) {
				System.out.println(validation(R, n));
			} else {
				System.out.println("--" + R + " " + n);
			}

		}
		sc.close();
	}

	static String validation(String realNum, int exponention) {

		final String intString = realNum.replaceAll("\\.", "");
		BigDecimal bigInt = new BigDecimal(intString);
		BigDecimal result = bigInt.pow(exponention);

		int pointPostion = realNum.indexOf(".");
		if (pointPostion > 0) {
			pointPostion = realNum.length() - realNum.indexOf(".") - 1;
			int finalPointPos = 0;
			for (int i = 0; i < exponention; i++) {
				finalPointPos += pointPostion;
			}
			String middle = result.toString();
			if (middle.length() < finalPointPos) {
				String zeroString = "";
				int zeroNum = finalPointPos - middle.length();
				for (int i = 0; i < zeroNum; i++) {
					zeroString += "0";
				}
				return "." + zeroString + middle;
			} else {
				finalPointPos = middle.length() - finalPointPos;
				return middle.substring(0, finalPointPos) + "." + middle.substring(finalPointPos);
			}

		} else {
			return result.toString();
		}

	}

}