package sw.luogu.stage2;

import java.util.Scanner;

public class P1017 {
    //30000=11011010101110000(base-2)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();

        System.out.print(N + "=");
        trans(N,R);
        System.out.println("(base" + R + ")");
    }

    private static void trans(int n, int r) {
        if (n == 0) return;
        int mod = n % r;
        if (mod < 0) {
            mod -= r;
            n += r;
        }
        if (mod >= 10) mod = 'A' + (mod - 10);
        else mod += '0';

        trans(n/r,r);
        System.out.print((char)mod);
    }
}
