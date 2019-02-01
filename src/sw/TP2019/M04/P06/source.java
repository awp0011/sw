package sw.TP2019.M04.P06;

import java.util.Scanner;

public class source {
    public static void main(String[] args) {
        long MOD = 1_000_000_007L;
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long m = sc.nextLong();
        long ans = 1;
        long base = a;
        while (m > 0) {
            if ((m & 1) == 1) {
                ans *= base;
                ans %= MOD;
            }
            base *= base;
            base %= MOD;
            m >>= 1;
        }
        System.out.println(ans);
    }
}
