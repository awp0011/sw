package sw.pro.Exponentiation;

import java.math.BigDecimal;

public class Main2 {

	public static void main(String[] args) {
		//System.out.println(validation("95.123", 12));
		//System.out.println(validation("0.4321", 20));
		System.out.println(validation(.00001f, 1));
		
	}

	static String validation(float realNum, int exponention) {
		final String realString = (""+realNum);
		final String intString = realString.replaceAll("\\.", "");
		BigDecimal bigInt = new BigDecimal(intString);
		BigDecimal result = bigInt.pow(exponention);

		int pointPostion = realString.indexOf(".");
		if (pointPostion > 0) {
			pointPostion = realString.length() - realString.indexOf(".") - 1;
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
				return middle.substring(0, finalPointPos) + "." + middle.substring( finalPointPos);
			}

		} else {
			return result.toString();
		}

	}

}