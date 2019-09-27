package sw.luogu.stage2;

import java.math.BigInteger;
import java.util.Scanner;

public class P1303 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.nextLine());
        BigInteger b = new BigInteger(sc.nextLine());
        System.out.println((a.multiply(b)).toString());
    }
}
