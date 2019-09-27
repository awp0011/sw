package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger a = BigInteger.valueOf(2);
        BigInteger ans = BigInteger.valueOf(1);
        while (n != 0) {//快速幂
            if ((n & 1) != 0)
                ans = ans.multiply(a);
            a = a.multiply(a);
            n >>= 1;
        }
        ans = ans.subtract(BigInteger.ONE);
        String s = ans.toString();
        int b = s.length() - 500;
        System.out.println(s.length());
        for (int i = 0; i < 10; i++) {
            System.out.println(s.substring(b, b + 50));
            b += 50;
        }
    }
}
